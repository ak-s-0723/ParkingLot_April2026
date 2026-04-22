package org.example.parking_lot_april2026.repos;

import org.example.parking_lot_april2026.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepo {
    private Map<Long,Ticket> ticketMap = new TreeMap<>();

    private static Long counter = 0L;

    public TicketRepo() {
    }

    public Ticket save(Ticket ticket) {
        counter++;
        ticket.setId(counter);
        ticketMap.put(counter,ticket);
        return ticket;
    }
}
