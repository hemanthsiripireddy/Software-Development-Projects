package org.example.services;

import org.example.models.*;

import java.util.*;

 public class TrainScheduleManagement {
   private  static TrainScheduleManagement trainScheduleManagement;

    public  static  TrainScheduleManagement getInstance(){
        if(trainScheduleManagement==null)
            trainScheduleManagement=new  TrainScheduleManagement();
        return trainScheduleManagement;

    }
    Map<String,Map<String,Map<Date,List<Train>>>> trainsByFilter=new HashMap<>();
    Map<Integer,Train> trains;

    private TrainScheduleManagement() {
        trainsByFilter=new HashMap<>();
        trains=new HashMap<>();
    }

    public List<Train> search(String source, String destination){
        List<Train>res=new ArrayList<>();
        Map<Date,List<Train>> cur=trainsByFilter.getOrDefault(source,null).getOrDefault(destination,null);
        if(cur!=null){
            for(Date date:cur.keySet()){
                res.addAll(cur.get(date));
            }
            return res;
        }
        return null;

    }
    public List<Train> search(String source, String destination, Date date){
        List<Train>res=new ArrayList<>();
        List<Train> cur=trainsByFilter
                .getOrDefault(source,null).getOrDefault(destination,null).getOrDefault(date,null);
        if(cur!=null){
            res.addAll(cur);
            return res;
        }

        return null;

    }


    public int numberOfSeatsAvailable(Integer  trainId,ClassType classType){



        return trains.get(trainId).getNumberOfAvailableSeats(classType);
    }

     List<Seat> bookSeat(Integer trainId, List<Seat> seats){
       return trains.get(trainId).bookSeats(seats);


    }
     boolean cancelSeat(List<Seat>seats){
       return seats.get(0).getTrain().cancelSeats(seats);

    }
   // public
     public void addTrain(Train train){
        trains.put(train.getTrainId(),train);

        Map<String,Map<Date,List<Train>>> trainsBySource=trainsByFilter.
                getOrDefault(train.getSource().getStationName(),new HashMap<>());
        trainsByFilter.put(train.getSource().getStationName(),trainsBySource);
         Map<Date,List<Train>> trainsByDestination=trainsBySource.getOrDefault(train.getDestination().getStationName(),new HashMap<>());
         trainsBySource.put(train.getDestination().getStationName(),trainsByDestination);
        List<Train> trainsByDate= trainsByDestination.
                getOrDefault(train.getDate(),new ArrayList<>());
        trainsByDestination.put(train.getDate(),trainsByDate);
        trainsByDate.add(train);

     }
}
