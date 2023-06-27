package Manager;

import Models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

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

    public void openRegistrationForm(){
        wd.findElement(By.xpath("//*[.=' Sign up ']")).click();
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
    public void fillLoginForm(User user){
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    public void fillRegistrationForm(User user){
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastName());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
        clickCheckBox();
    }

    public void clickCheckBox(){
        //variant 1
//        click(By.cssSelector("label[for='terms-of-use']"));
        //variant 2
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use').click()");//document.querySelector('#terms-of-use').checked
        //variant 3
        Rectangle rect = wd.findElement(By.cssSelector("div.checkbox-container")).getRect();
        int x = rect.getX() + 5;
        int y = rect.getY() + rect.getHeight() / 4;
        Actions action = new Actions(wd);
        action.moveByOffset(x, y).click().perform();
    }

    public void submitLoginForm() {
        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    public boolean isLoggedSuccess() {
        return isElementPresent(By.xpath("//h2 [contains(text(),'success')]"));
    }
    public boolean isRegistrationNotSuccess() {
        return isElementPresent(By.xpath("//div[@class='ng-star-inserted']"));
    }

    public void login(User user){
        openLoginForm();
        fillLoginForm(user);
        submitLoginForm();
        closeDialog();
    }

    public void submitLogin(){
        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }

}