package org.example.services;

import org.example.models.Seat;
import org.example.models.Ticket;
import org.example.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 public class TicketManagement {
     private  int autoInt=0;
    TrainScheduleManagement trainScheduleManagement;
    Map<Integer, List<Ticket>> userTicketMap=new HashMap<>();
    Map<Integer,Ticket> tickets;
    private   static  TicketManagement ticketManagement;
    public static  TicketManagement  getInstance(){
        if(ticketManagement==null)
            ticketManagement=new TicketManagement();
        return ticketManagement;

    }

    private  TicketManagement() {
        trainScheduleManagement=TrainScheduleManagement.getInstance();
        userTicketMap=new HashMap<>();
        tickets=new HashMap<>();
    }

    public  List<Ticket> getMyTickets(int userId){
        if(userTicketMap.containsKey(userId))
            return userTicketMap.get(userId);
        return null;
    }
    public boolean cancelTicket(int userId,int ticketId){
     Ticket ticket=   tickets.get(ticketId);
     trainScheduleManagement.cancelSeat(ticket.getSeats());
     tickets.remove(ticketId);
     userTicketMap.get(userId).remove(ticket);
        return true;
    }
    public Ticket bookTicket(User user, Integer trainId, List<Seat> seats){
       List<Seat> res= trainScheduleManagement.bookSeat(trainId,seats);
       if(res!=null){
           Ticket ticket=new Ticket();
           ticket.setTicketId(autoInt++);
           ticket.setUser(user);
           ticket.setSeats(res);
           tickets.put(ticket.getTicketId(),ticket);
          List<Ticket>userTickets= userTicketMap.getOrDefault(user.getUserId(), new ArrayList <>());
          userTicketMap.put(user.getUserId(),userTickets);
          userTickets.add(ticket);
           return  ticket;
       }
       return null;
    }


}
