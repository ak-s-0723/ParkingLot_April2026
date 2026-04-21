package org.example.parking_lot_april2026.controllers;

import org.example.parking_lot_april2026.dtos.IssueTicketRequestDto;
import org.example.parking_lot_april2026.dtos.IssueTicketResponseDto;
import org.example.parking_lot_april2026.dtos.ResponseStatus;
import org.example.parking_lot_april2026.models.Ticket;
import org.example.parking_lot_april2026.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto) {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        try {
            Ticket ticket = ticketService.issueTicket(requestDto.getGateId(),
                    requestDto.getVehicleType(),
                    requestDto.getVehicleNumber());
            issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            issueTicketResponseDto.setTicketId(ticket.getId());
            issueTicketResponseDto.setSlotNumber(ticket.getParkingSlot().getParkingSlotNumber());
           return issueTicketResponseDto;
        }catch (Exception exception) {
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            issueTicketResponseDto.setFailureMessage(exception.getMessage());
            return issueTicketResponseDto;
        }
    }
}
