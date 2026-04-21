package org.example.parking_lot_april2026.services;

import org.example.parking_lot_april2026.models.*;
import org.example.parking_lot_april2026.repos.GateRepo;
import org.example.parking_lot_april2026.repos.TicketRepo;
import org.example.parking_lot_april2026.repos.VehicleRepo;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepo gateRepo;

    private VehicleRepo vehicleRepo;

    private TicketRepo ticketRepo;

    public TicketService(GateRepo gateRepo, VehicleRepo vehicleRepo,
                         TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
        this.gateRepo = gateRepo;
        this.vehicleRepo = vehicleRepo;
    }

    public Ticket issueTicket(Long gateId, VehicleType vehicleType, String vehicleNumber) {
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(new Date());

        Optional<Gate> optionalGate = gateRepo.findGateById(gateId);

        if(optionalGate.isEmpty()) {
            throw new RuntimeException("Gate not found");
        }

        Gate gate = optionalGate.get();

        Optional<Vehicle> optionalVehicle = vehicleRepo.getVehicleByVehicleNumber(vehicleNumber);

        Vehicle vehicle = null;
        if (optionalVehicle.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setCreatedAt(new Date());
            vehicle = vehicleRepo.save(vehicle);
        } else {
           vehicle = optionalVehicle.get();
        }

        ticket.setEntryGate(gate);
        ticket.setVehicle(vehicle);

        ParkingLot parkingLot = gate.getParkingLot();
        ParkingSlot parkingSlot = parkingLot.getSlotAssigingStrategy().assignSlot(parkingLot,vehicleType);
        ticket.setParkingSlot(parkingSlot);
        ticket.setOperator(gate.getOperator());

        return ticketRepo.save(ticket);
    }

}
