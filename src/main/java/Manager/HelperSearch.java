package Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase{

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void openSearchForm(){
        pause(2000);
        click(By.cssSelector("[href='search']"));
    }

    public void fillSearchForm(String city, String dateFrom,String dateTo){
        fillCity(city);
        fillPeriodDates(dateFrom, dateTo);
    }

    public void fillSearchFormDayPicker(String city, String dateFrom, String dateTo){
        fillCity(city);
        selectPeriodDaysDatePicker(dateFrom, dateTo);
    }

    public void fillSearchFormMonthPicker(String city, String dateFrom,String dateTo){
        fillCity(city);
        selectPeriodMonthsDatePicker(dateFrom, dateTo);
    }

    public void fillSearchFormYearsPicker(String city, String dateFrom,String dateTo){
        fillCity(city);
        selectPeriodYearsDatePicker(dateFrom, dateTo);
    }

    public void fillCity(String city){
        type(By.id("city"), city);
        click(By.cssSelector("div.pac-item"));
    }

    public void fillPeriodDates(String dateFrom,String dateTo){
        type(By.id("dates"), dateFrom + " - " + dateTo);
    }

    public void submitSearchForm(){
        wd.findElement(By.cssSelector("button[type='submit']")).submit();
    }

    public boolean isSearchSuccess(){
        return isElementPresent((By.xpath("//div[2]//app-sub-search[1]//div[1]//form[1]//button[1]")));
    }

    public void selectPeriodDaysDatePicker(String dateFrom,String dateTo){
        String[] startDate = dateFrom.split("/");
        String[] endDate = dateTo.split("/");
        pause(1000);
        click(By.id("dates"));
//        click(By.xpath("//div[.=' " + startDate[1] + " ']"));
//        click(By.xpath("//div[.=' " + endDate[1] + " ']"));
        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEndDate = String.format("//div[.=' %s ']", endDate[1]);
        click(By.xpath(locatorStartDate));
        click(By.xpath(locatorEndDate));
        pause(1000);
    }

    public void selectPeriodMonthsDatePicker(String dateFrom,String dateTo){
        int fromNowToStart = 0, fromStartToEnd = 0;
        String[] startDate = dateFrom.split("/");
        String[] endDate = dateTo.split("/");
        pause(1000);
        click(By.id("dates"));
        fromStartToEnd = Integer.parseInt(endDate[0]) - Integer.parseInt(startDate[0]);
        if(LocalDate.now().getMonthValue() != Integer.parseInt(startDate[0])){
            fromNowToStart = Integer.parseInt(startDate[0]) - LocalDate.now().getMonthValue();
        }
        for(int i = 0; i < fromNowToStart; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        String locatorStartDate = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEndDate = String.format("//div[.=' %s ']", endDate[1]);
        click(By.xpath(locatorStartDate));
        pause(1000);
        for(int i = 0; i < fromStartToEnd; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorEndDate));
        pause(3000);
    }

    public void selectPeriodYearsDatePicker(String dateFrom, String dateTo){
        LocalDate startDate = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate endDate = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate nowDate = LocalDate.now();
        String locatorStartDate = String.format("//div[.=' %s ']", startDate.getDayOfMonth());
        String locatorEndDate = String.format("//div[.=' %s ']", endDate.getDayOfMonth());
        pause(3000);
        click(By.id("dates"));
        int startToEndMonth = startDate.getYear() - nowDate.getYear() == 0 ?
                startDate.getMonthValue() - nowDate.getMonthValue() :
                12 - nowDate.getMonthValue() + startDate.getMonthValue();
        for(int i = 0; i < startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorStartDate));
        startToEndMonth = endDate.getYear() - startDate.getYear() == 0 ?
                endDate.getMonthValue() - startDate.getMonthValue() :
                12 - startDate.getMonthValue() + endDate.getMonthValue();

        for(int i = 0; i < startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorEndDate));
    }

}
