package manager;

import Models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm(){
      click(By.xpath("//a[.=' Let the car work ']"));
    }

    public void fillCarForm(Car car){

    }

    public void typeLocation(String address){
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector("div.pickUpPlace"));
    }

}
