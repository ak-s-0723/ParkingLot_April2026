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

    public TicketService(GateRepo gateRepo,VehicleRepo vehicleRepo,TicketRepo ticketRepo) {
        this.gateRepo = gateRepo;
        this.vehicleRepo = vehicleRepo;
        this.ticketRepo = ticketRepo;
    }

    public Ticket issueTicket(Long gateId, String vehicleNumber, VehicleType vehicleType) {
        //We need to create ticket, store it in DB and then return from here
       //To create ticket, what all we need
        Ticket ticket = new Ticket();
        //Lets go to ticket class and see for creating it, what all we need

        //Gate -> gateId (already in request)
        //Operator -> can get from gate object
        //slot we need to assign
        //vehicle info we are getting in request

        Optional<Gate> gateOptional = gateRepo.findGateById(gateId);

        if(gateOptional.isEmpty()) {
            throw new RuntimeException("Gate not found");
        }

        Gate gate = gateOptional.get();
        ticket.setEntryGate(gate);
        ticket.setOperator(ticket.getOperator());
        ticket.setEntryTime(new Date());

        Optional<Vehicle> vehicleOptional = vehicleRepo.findVehicleByNumber(vehicleNumber);

        Vehicle vehicle = null;
        if(vehicleOptional.isEmpty()) {
            //This means, its a new vehicle which you need to onboard to your db as well.
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setCreatedAt(new Date());
            vehicle.setLastUpdatedAt(new Date());
            vehicle = vehicleRepo.save(vehicle);
        } else {
            vehicle = vehicleOptional.get();
        }

        ticket.setVehicle(vehicle);

        //assign slot
        // In order to get SlotAssigningStrategy, we need parking lot
        // but we are not accepting parking lot object input here
        // how can i get parking lot object ?
        // We can get through gate
        //when we were doing schema design, do you remember
        // we have parking lot id in case of gate table
        // In ParkingLotRepo, We can have a method findByGate(gate)
        //This will work in background like
        //select * from gate join parking_lot on  gate_id = 5 and gate.parking_id = parking_lot.id
        //ORM can help with this

        //We could have also received parkinglot id in request which would have made our job easier.
        //Optional<ParkingLot> optionalParkingLot = parkingLotRepo.findByGate(gate);

        ParkingLot parkingLot = gate.getParkingLot();
        ParkingSlot parkingSlot = parkingLot
                .getSlotAssigningStrategy()
                .assignSlot(parkingLot,vehicleType);

        ticket.setParkingSlot(parkingSlot);

        return ticketRepo.save(ticket);
    }
}


//services don't talk to DBs directly
//Services talk to repos, Repos talk to DB via ORMs
