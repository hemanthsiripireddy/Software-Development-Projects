import org.example.apis.Login;
import org.example.apis.Page;
import org.example.apis.SignUp;
import org.example.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class AddTrainTest {
    Page page;
    Login login;
    @Before
    public void beforeTest(){
        SignUp signUp=new SignUp();
        boolean res=signUp.singUp("hemanth","Siripi" ,"admin","hemanth");
        login=new Login();
         page =login.login("admin","hemanth");
    }
    @Test

    public void addTrain(){
        Train train=new Train();
        train.setTrainId(1);
        train.setSource(new Station(1,"tirupati"));
        train.setDestination(new Station(2,"chennai"));
         train.setDate(new Date());
        //train.setDate(new Date(System.cur));
        train.addSeat(new Seat(1,ClassType._2S, SeatPosition.WS,train));
        train.addSeat(new Seat(2,ClassType._2S, SeatPosition.WS,train));
      boolean res=  page.addTrain(train);

        Assert.assertTrue(res);
    }
}
