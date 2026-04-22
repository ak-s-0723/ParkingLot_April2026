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
    public static void main(String[] arg) {

        //**********SHOULD BE DONE BY ADMIN*******************
        ParkingLotRepo parkingLotRepo = new ParkingLotRepo();
        GateRepo gateRepo = new GateRepo();
        Optional<ParkingLot> parkingLotOptional = parkingLotRepo.getParkingLotById(1L);
        ParkingLot parkingLot = parkingLotOptional.get();
        Optional<Gate> gateOptional = gateRepo.findGateById(1L);
        Gate gate = gateOptional.get();
        gate.setParkingLot(parkingLot);

        ParkingFloorRepo parkingFloorRepo = new ParkingFloorRepo();
        ParkingSlotRepo parkingSlotRepo = new ParkingSlotRepo();
        ParkingSlot parkingSlot = parkingSlotRepo.getParkingSlotById(1L).get();
        ParkingFloor parkingFloor =  parkingFloorRepo.getParkingFloorById(1L).get();

        List<ParkingSlot> parkingSlotList = new ArrayList<>();
        parkingSlotList.add(parkingSlot);
        parkingFloor.setParkingSlots(parkingSlotList);

        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        parkingFloorList.add(parkingFloor);
        parkingLot.setParkingFloors(parkingFloorList);

        //**************ASSOCIATING DATA FOR TESTING***************




        TicketRepo ticketRepo = new TicketRepo();
        VehicleRepo vehicleRepo = new VehicleRepo();

        TicketService ticketService = new TicketService(gateRepo,vehicleRepo,ticketRepo);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setVehicleType(VehicleType.TWO_WHEELER);
        requestDto.setGateId(1L);
        requestDto.setVehicleNumber("PB02 AB 3432");

        IssueTicketResponseDto responseDto = ticketController.issueTicket(requestDto);

        if(responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            System.out.println("Ticket Id = "+responseDto.getTicketId());
            System.out.println("Slot number = "+responseDto.getSlotNumber());
        } else {
            System.out.println(responseDto.getFailureMessage());
        }
    }
}
