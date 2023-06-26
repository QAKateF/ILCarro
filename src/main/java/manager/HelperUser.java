package manager;

import Models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public void closeDialog() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[.=' Logout ']"));
    }

    public void openLoginForm() {
        click(By.xpath("//a[.=' Log in ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
    public void fillLoginForm(User user){
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }
    public void submitLoginForm() {
        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    public boolean isLoggedSuccess() {
        return isElementPresent(By.xpath("//h2 [contains(text(),'success')]"));
    }

    public void login(User user){
        openLoginForm();
        fillLoginForm(user);
        submitLoginForm();
        closeDialog();
    }
}