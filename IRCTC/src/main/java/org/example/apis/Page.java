package org.example.apis;

import org.example.models.ClassType;
import org.example.models.Seat;
import org.example.models.Ticket;
import org.example.models.Train;

import java.util.Date;
import java.util.List;

public interface Page {

    public List<Ticket> getMyTickets();
    public Ticket bookTicket(int trainId, List<Seat>seats);
    public boolean cancelTicket(int ticketid);
    public List<Train> search(String source, String destination);
    public List<Train> search(String source, String destination, Date date);
    public int numberOfSeatsAvailable(Integer  trainId, ClassType classType);
    public boolean addTrain(Train train);
}
