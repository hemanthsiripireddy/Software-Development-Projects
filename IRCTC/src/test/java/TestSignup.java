import org.example.apis.SignUp;
import org.junit.Assert;
import org.junit.Test;

public class TestSignup {

    @Test
    public void signUpFirstTime(){
        synchronized ( TestSignup.class) {
            SignUp signUp = new SignUp();
            boolean res = signUp.singUp("hemanth", "Siripi", "hemanth", "hemanth");
            Assert.assertFalse(res);
        }


    }
    @Test
    public void singupWithExisintUser(){
        SignUp signUp=new SignUp();
      boolean res=signUp.singUp("hemanth","Siripi" ,"hemanth","hemanth");
        res=signUp.singUp("hemanth","Siripi" ,"hemanth","hemanth");
        Assert.assertFalse(res);
    }
}
