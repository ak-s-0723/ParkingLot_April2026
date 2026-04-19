package org.example.parking_lot_april2026;

import org.example.parking_lot_april2026.controllers.TicketController;
import org.example.parking_lot_april2026.dtos.IssueTicketRequestDto;
import org.example.parking_lot_april2026.dtos.IssueTicketResponseDto;
import org.example.parking_lot_april2026.dtos.ResponseStatus;
import org.example.parking_lot_april2026.models.VehicleType;
import org.example.parking_lot_april2026.repos.GateRepo;
import org.example.parking_lot_april2026.repos.TicketRepo;
import org.example.parking_lot_april2026.repos.VehicleRepo;
import org.example.parking_lot_april2026.services.TicketService;

public class Client {
    public static void main(String[] a) {
        //Should we first of all create TicketController Object or
        //TicketController object depends on something ?
        //Same for TicketService

        //This will be done by spring. we don't have to do

        GateRepo gateRepo = new GateRepo();
        VehicleRepo vehicleRepo = new VehicleRepo();
        TicketRepo ticketRepo = new TicketRepo();

        TicketService ticketService = new TicketService(gateRepo,vehicleRepo,ticketRepo);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1L);
        issueTicketRequestDto.setVehicleNumber("PB02 AB 3234");
        issueTicketRequestDto.setVehicleType(VehicleType.TWO_WHEELER);

        IssueTicketResponseDto issueTicketResponseDto =
                ticketController.issueTicket(issueTicketRequestDto);

        if(issueTicketResponseDto.getResponseStatus() == ResponseStatus.SUCCESS) {
            System.out.println(issueTicketResponseDto.getTicketId());
        } else {
            System.out.println(issueTicketResponseDto.getFailureMessage());
        }



    }
}
