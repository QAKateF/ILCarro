import Models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()) app.getUser().logout();
    }

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Good")
                .withLastName("Day")
                .withEmail("qa38" + i + "@mail.nm")
                .withPassword("Ghjk1234!");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        logger.info("registrationPositive starts with credentials: email: "
                + user.getEmail() + " & password: " + user.getPassword());
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void registrationNegativeWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Good")
                .withLastName("Day")
                .withEmail("qa38" + i + "@mail.nm")
                .withPassword("Ghjk1234");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isRegistrationNotSuccess());
    }

    @AfterMethod
    public void postcondition(){
        app.getUser().closeDialog();
    }
}