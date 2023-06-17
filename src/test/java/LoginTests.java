import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositive(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("qa38@mail.mn","Ghjk1234!");
        app.getUser().submitLoginForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLogged());
    }

}