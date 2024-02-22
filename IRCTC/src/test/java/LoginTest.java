import org.example.apis.Login;
import org.example.apis.Page;
import org.example.apis.SignUp;
import org.example.apis.user.UserPage;
import org.example.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

 public class LoginTest {
    User user;
    Login login;
    @Before
    public void beforeTest(){
        SignUp signUp=new SignUp();
        boolean res=signUp.singUp("hemanth","Siripi" ,"hemanth","hemanth");
        login=new Login();
    }
   @Test
    public void loginWithCorrectCredentails(){
        Page userPage =login.login("hemanth","hemanth");
        Assert.assertNotNull(userPage);

    }
    @Test
    public void loginWithInCorrectCredentails(){
        Page userPage =login.login("hemanth1","hemanth");
        Assert.assertNull(userPage);

    }


}
