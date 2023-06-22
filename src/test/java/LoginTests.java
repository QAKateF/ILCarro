import Models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        app.getUser().closeDialog();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLogged());
    }
    @Test
    public void loginPositiveUser() {
        //User user = new User("qa38@mail.mn", "Ghjk1234!");
        User user = new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().submitLoginForm();
        app.getUser().closeDialog();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLogged());
    }
    @Test
    public void loginPositiveUserData() {
        User user = new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        app.getUser().closeDialog();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLogged());
    }

    @AfterMethod
    public void postcondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

}