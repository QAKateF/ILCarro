package Manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    //    WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;

    public HelperUser getUser() {
        return user;
    }

    public HelperCar getCar() {
        return car;
    }

    @BeforeSuite
    public void init(){
//        wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new WebDrListener());
        user = new HelperUser(wd);
        car = new HelperCar(wd);
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        //wd.quit();
    }

    @BeforeMethod
    public void startLogger(Method method) {
        logger.info(method.getName() + "is started");
    }

    @AfterMethod
    public void finishLogger(Method method) {
        logger.info("****************************************************************");
    }
}