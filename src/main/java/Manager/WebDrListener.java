package Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDrListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(WebDrListener.class);

    public WebDrListener() {super();}
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver){
        super.beforeFindBy(by, element, driver);
        logger.info("Start searching element -----------> " + by);
}
    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver){
        super.beforeFindBy(by, element, driver);
        logger.info("Element with locator -----------> " + by + " is found");
    }

    @Override
    public void onException (Throwable throwable, WebDriver driver){
        super.onException(throwable, driver);
        logger.info("Something went wrong!");
        logger.info(throwable.getMessage());
        logger.info(throwable.fillInStackTrace().getMessage());
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        String link = "src/test/Screenshots/screenshot-"  + i + ".png";
        HelperBase helperBase = new HelperBase(driver);
        helperBase.takeScreenshot(link);
        logger.info("This is a link to screenshot with error -----------> " + link);
    }
}

