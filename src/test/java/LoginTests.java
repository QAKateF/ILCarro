import Manager.ProviderData;
import Manager.TestNGListener;
import Models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNGListener.class)

public class LoginTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
            app.getUser().pause(1000);
        }
    }
    @Test
    public void loginPositive(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("qa38@mail.mn","Ghjk1234!");
        app.getUser().submitLoginForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @Test
    public void loginPositiveProps(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(app.getEmail(), app.getPassword());
        app.getUser().submitLoginForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @Test
    public void loginPositiveUser() {
        User user = new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @Test
    public void loginPositiveUserData() {
        User user = new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @Test (dataProvider = "userDTO",dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user) {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
    @AfterMethod
    public void postcondition(){
        app.getUser().closeDialog();
        }
}
