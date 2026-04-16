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

//    public Response issueTicket(Request request)
     public IssueTicketResponseDto issueTicket(
             IssueTicketRequestDto request) {
          IssueTicketResponseDto issueTicketResponseDto = new
                  IssueTicketResponseDto();

          try {
               Ticket ticket = ticketService.issueTicket(request.getGateId(),
                       request.getVehicleNumber(),
                       request.getVehicleType());
               issueTicketResponseDto.setTicketId(ticket.getId());
               issueTicketResponseDto.setSlotNumber(ticket.getParkingSlot().getParkingSlotNumber());
               issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
          }catch (Exception exception) {  // Because waiter handle req of unavailable items
               issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
               issueTicketResponseDto.setFailureMessage(exception.getMessage());
          }

          return issueTicketResponseDto;
     }
}

// from controller, you will be calling service
// client will send request (which will contain some data)


// We will not just send ticket, but a Response
// TicketId
// SlotNumber
// Status -> SUCCESS/FAILURE
// FailureMessage
//because remaining things like vehicle number,
// operator can be hardcoded by machine. This is info we need to
// send from backend
//So now, will we send separately, or we can create a separate class
//in which all these attributes will be there
// It is known as DTO -> creating a class for transferring data