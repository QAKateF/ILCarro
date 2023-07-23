package Manager;

import Models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm(){
        pause(5000);
        click(By.xpath("//a[.=' Let the car work ']"));
    }

    public void addAnotherCar(){
        pause(5000);
        click(By.xpath("//button[.='Add another car']"));
    }

    public void closeCarForm(){
        pause(2000);
        Rectangle rect = wd.findElement(By.cssSelector(".cdk-overlay-backdrop.cdk-overlay-dark-backdrop.cdk-overlay-backdrop-showing")).getRect();
        int x = rect.getX() + 10;
        int y = rect.getY() + 10;
        Actions action = new Actions(wd);
        action.moveByOffset(x, y).click().perform();
    }

    public void fillCarForm(Car car){
        if(!isCarFormPresent()) return;
        typeLocation(car.getLocation());
        type(By.id("make"), car.getManufacture());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
        clickSerialNumber(car.getCarRegNumber()); // type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
    }

    public void typeLocation(String address){
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector("div.pac-item"));
    }

    public boolean isAddedSuccess() {
        return isElementPresent(By.xpath("//h2 [contains(text(),'added successful')]"));
    }

//    public void clickSerialNumber(String carRegNumber){
//        Rectangle rect = wd.findElement(By.id("serialNumber")).getRect();
//        int x = rect.getX() + rect.getWidth() * 7 / 8;
//        int y = rect.getY() + rect.getHeight() / 2;
//        Actions action = new Actions(wd);
//        action.moveByOffset(x, y).click().perform();
    public void clickSerialNumber(String text){
        WebElement rect = wd.findElement(By.id("serialNumber"));
        Actions action = new Actions(wd);
        action.moveToElement(rect).click().perform();
        rect.clear();
        rect.sendKeys(text);
    }

    public boolean isCarFormPresent(){
        return new WebDriverWait(wd, 10).until
        (ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("h2")),"details"));
    }

    public void select(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);
    }

}
