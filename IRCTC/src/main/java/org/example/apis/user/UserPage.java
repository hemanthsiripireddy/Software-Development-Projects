package org.example.apis.user;

import org.example.apis.Page;
import org.example.models.*;
import org.example.services.TicketManagement;
import org.example.services.TrainScheduleManagement;
import org.example.services.UserManagement;

import java.util.Date;
import java.util.List;

public class UserPage implements Page {
    User user;

    TicketManagement ticketManagement;
    TrainScheduleManagement trainScheduleManagement;
    UserManagement userManagement;


     public List<Ticket> getMyTickets(){
        return ticketManagement.getMyTickets(user.getUserId());




     }
     public Ticket bookTicket(int trainId, List<Seat>seats){
        return ticketManagement.bookTicket(user,trainId,seats);
     }
     public boolean cancelTicket(int ticketid){
         return ticketManagement.cancelTicket(user.getUserId(),ticketid);
     }
     public List<Train> search(String source,String destination){
        return trainScheduleManagement.search(source,destination);
     }
    public List<Train> search(String source, String destination, Date date){
        return trainScheduleManagement.search(source,destination,date);
    }
    public int numberOfSeatsAvailable(Integer  trainId, ClassType classType){
         return  trainScheduleManagement.numberOfSeatsAvailable(trainId,classType);
    }

    @Override
    public boolean addTrain(Train train) {
        return false;
    }

    public UserPage(User user) {

         this.user = user;
         ticketManagement=TicketManagement.getInstance();
         trainScheduleManagement=TrainScheduleManagement.getInstance();
         userManagement=UserManagement.getInstance();
    }

    public UserPage() {

    }
}

