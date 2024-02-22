package org.example.models;

import java.util.*;

public class Train {
    private  int trainId;
    Map<ClassType, Map<SeatPosition, Queue<Seat>>>availableSeats;
    Map<ClassType,  Queue<Seat>>availableSeatsByClassType;
    Map<ClassType, Integer>availableSeatsCount;
    Map<Integer,Seat>seats;
    public  void addSeats(List<Seat> seats){
        cancelSeats(seats);
    }

    public Train() {
        availableSeats=new HashMap<>();
     //   availableSeatsCount=new HashMap<>();
        availableSeatsCount=new HashMap<>();
        availableSeatsByClassType=new HashMap<>();
        seats=new HashMap<>();

    }


    private Station source;
    private Station destination;
    private Date date;

   public int getNumberOfAvailableSeats(ClassType classType){
       return availableSeatsCount.getOrDefault(classType,0);
   }
   public List<Seat> bookSeats(List<Seat> seats){
       Map<ClassType, Integer>countForEachClassType=new HashMap<>();
       for(Seat seat:seats){
           countForEachClassType.put(seat.getClassType(),countForEachClassType.getOrDefault(seat.getClassType(),0)+1);
       }
       for(ClassType classType:countForEachClassType.keySet()){
           if(countForEachClassType.get(classType)>availableSeatsCount.get(classType))
               return null;

       }
       Ticket ticket=new Ticket();
       List<Seat>res=new ArrayList<>();
       for(Seat seat:seats){

           Map<SeatPosition,Queue<Seat>> cur=availableSeats.get(seat.getClassType());
           Queue<Seat> s=cur.getOrDefault(seat.getSeatPosition(),null);
           if(s!=null&&s.size()>0){
               res.add(s.poll());
           }else{
             Seat curSeat=  availableSeatsByClassType.get(seat.getClassType()).poll();
             res.add(curSeat);

           }
       }
       return res;

   }


   public boolean cancelSeats(List<Seat> seats){
       for(Seat seat:seats){
         Map<SeatPosition,Queue<Seat>> seatByPos=availableSeats.getOrDefault(seat.getClassType(),new HashMap<>());
         availableSeats.put(seat.getClassType(),seatByPos);
          Queue<Seat> curSeats=seatByPos.getOrDefault(seat.getSeatPosition(),new LinkedList<>());
          seatByPos.put(seat.getSeatPosition(),curSeats);
          curSeats.add(seat);
           curSeats=availableSeatsByClassType.getOrDefault(seat.getClassType(),new LinkedList<>());
           availableSeatsByClassType.put(seat.getClassType(),curSeats);
           curSeats.add(seat);
           availableSeatsCount.put(seat.getClassType(),availableSeatsCount.get(seat.getClassType())+1);




       }
       return true;

   }
    public boolean cancelSeats(Seat seat){

            Map<SeatPosition,Queue<Seat>> seatByPos=availableSeats.getOrDefault(seat.getClassType(),new HashMap<>());
            availableSeats.put(seat.getClassType(),seatByPos);
            Queue<Seat> curSeats=seatByPos.getOrDefault(seat.getSeatPosition(),new LinkedList<>());
            seatByPos.put(seat.getSeatPosition(),curSeats);
            curSeats.add(seat);
            curSeats=availableSeatsByClassType.getOrDefault(seat.getClassType(),new LinkedList<>());
            availableSeatsByClassType.put(seat.getClassType(),curSeats);
            curSeats.add(seat);
            availableSeatsCount.put(seat.getClassType(),availableSeatsCount.getOrDefault(seat.getClassType(),0)+1);





        return true;

    }
   public boolean addSeat(Seat seat){
       seats.put(seat.getId(),seat);
       cancelSeats(seat);

       return  true;
   }

    public Integer getTrainId() {
        return trainId;
    }

    public Station getSource() {
        return source;
    }

    public void setSource(Station source) {
        this.source = source;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }


}
