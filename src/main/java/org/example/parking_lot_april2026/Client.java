package org.example.parking_lot_april2026;

import org.example.parking_lot_april2026.controllers.TicketController;
import org.example.parking_lot_april2026.dtos.IssueTicketRequestDto;
import org.example.parking_lot_april2026.dtos.IssueTicketResponseDto;
import org.example.parking_lot_april2026.dtos.ResponseStatus;
import org.example.parking_lot_april2026.models.*;
import org.example.parking_lot_april2026.repos.*;
import org.example.parking_lot_april2026.services.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Client {
    public static void main(String[] a) {

        //Should we first of all create TicketController Object or
        //TicketController object depends on something ?
        //Same for TicketService

        //This will be done by spring. we don't have to do

        GateRepo gateRepo = new GateRepo();
        VehicleRepo vehicleRepo = new VehicleRepo();
        TicketRepo ticketRepo = new TicketRepo();

        ParkingLotRepo  parkingLotRepo = new ParkingLotRepo();
        ParkingSlotRepo parkingSlotRepo = new ParkingSlotRepo();
        ParkingFloorRepo parkingFloorRepo = new ParkingFloorRepo();

        //********IDEALLY DONE THROUGH ADMIN PORTAL***********
        Optional<ParkingLot> parkingLotOptional = parkingLotRepo.findParkingLotById(1L);
        ParkingLot parkingLot = parkingLotOptional.get();
        Optional<ParkingFloor> parkingFloorOptional = parkingFloorRepo.findParkingFloorById(1L);
        ParkingFloor parkingFloor = parkingFloorOptional.get();
        Optional<ParkingSlot> parkingSlotOptional = parkingSlotRepo.findParkingSlotById(1L);
        ParkingSlot parkingSlot = parkingSlotOptional.get();
        Optional<Gate> gateOptional = gateRepo.findGateById(1L);
        Gate gate = gateOptional.get();

        List<ParkingSlot> parkingSlotList = new ArrayList<>();
        parkingSlotList.add(parkingSlot);
        parkingFloor.setParkingSlots(parkingSlotList);
        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        parkingFloorList.add(parkingFloor);
        parkingLot.setParkingFloors(parkingFloorList);
        gate.setParkingLot(parkingLot);

        //******************


        TicketService ticketService = new TicketService(gateRepo,vehicleRepo,ticketRepo);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1L);
        issueTicketRequestDto.setVehicleNumber("PB02 AB 3234");
        issueTicketRequestDto.setVehicleType(VehicleType.TWO_WHEELER);

        IssueTicketResponseDto issueTicketResponseDto =
                ticketController.issueTicket(issueTicketRequestDto);

        if(issueTicketResponseDto.getResponseStatus() == ResponseStatus.SUCCESS) {
            System.out.println("Ticket Id = "+issueTicketResponseDto.getTicketId());
            System.out.println("Slot = "+issueTicketResponseDto.getSlotNumber());
        } else {
            System.out.println(issueTicketResponseDto.getFailureMessage());
        }



    }
}
