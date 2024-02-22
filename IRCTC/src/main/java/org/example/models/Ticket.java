package org.example.models;

import java.util.List;

public class Ticket {
    private  int ticketId;
    private User user;
    private List<Seat> seats;


    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getTicketId() {
        return ticketId;
    }
}
