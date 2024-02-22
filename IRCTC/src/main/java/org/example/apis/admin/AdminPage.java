package org.example.apis.admin;

import org.example.apis.Page;
import org.example.models.*;
import org.example.services.TrainScheduleManagement;

import java.util.Date;
import java.util.List;

public class AdminPage implements Page {
    User user;
    TrainScheduleManagement trainScheduleManagement;
    public AdminPage(User user)
    {
        this.user=user;
        trainScheduleManagement=TrainScheduleManagement.getInstance();

    }

    @Override
    public List<Ticket> getMyTickets() {
        return null;
    }

    @Override
    public Ticket bookTicket(int trainId, List<Seat> seats) {
        return null;
    }

    @Override
    public boolean cancelTicket(int ticketid) {
        return false;
    }

    @Override
    public List<Train> search(String source, String destination) {
        return null;
    }

    @Override
    public List<Train> search(String source, String destination, Date date) {
        return null;
    }

    @Override
    public int numberOfSeatsAvailable(Integer trainId, ClassType classType) {
        return 0;
    }

    public  boolean addTrain(Train train){
         trainScheduleManagement.addTrain(train);
         return true;


    }
}
