import org.example.apis.Login;
import org.example.apis.Page;
import org.example.apis.SignUp;
import org.example.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchTrain {
    Page page;
    Login login;
    @Before
    public void beforeTest(){
        SignUp signUp=new SignUp();
        boolean res=signUp.singUp("hemanth","Siripi" ,"admin","hemanth");
        login=new Login();
        page =login.login("admin","hemanth");
        Train train=new Train();
        train.setTrainId(1);
        train.setSource(new Station(1,"tirupati"));
        train.setDestination(new Station(2,"chennai"));
        train.setDate(new Date());
        //train.setDate(new Date(System.cur));
        train.addSeat(new Seat(1, ClassType._2S, SeatPosition.WS,train));
        train.addSeat(new Seat(2,ClassType._2S, SeatPosition.WS,train));
          page.addTrain(train);
         res=signUp.singUp("hemanth","Siripi" ,"hemanth","hemanth");
        login=new Login();
        page =login.login("hemanth","hemanth");

    }
    List<Train> res;
    @Test
    public void search(){
       res =page.search("tirupati","chennai");
        Assert.assertNotNull(res);
    }
    Ticket ticket;
    @Test
    public void book(){
        List<Train>res =page.search("tirupati","chennai");
        Seat seat=new Seat( ClassType._2S, SeatPosition.WS);
        List<Seat>seats=new ArrayList<>();
        seats.add(seat);
         ticket=page.bookTicket(res.get(0).getTrainId(),seats);
        Assert.assertNotNull(ticket);

    }
    @Test
    public void cancel(){
        List<Train>res =page.search("tirupati","chennai");
        Seat seat=new Seat( ClassType._2S, SeatPosition.WS);
        List<Seat>seats=new ArrayList<>();
        seats.add(seat);
        ticket=page.bookTicket(res.get(0).getTrainId(),seats);
      boolean ans= page.cancelTicket(ticket.getTicketId());
        Assert.assertTrue(ans);

    }
}
