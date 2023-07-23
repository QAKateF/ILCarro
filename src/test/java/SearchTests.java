import org.testng.Assert;
import org.testng.annotations.*;

public class SearchTests extends TestBase {

    @BeforeMethod
    public void precondition(){
            app.getSearch().openSearchForm();
    }

    @Test
    public void searchCarTestPositive(){
        app.getSearch().fillSearchForm("Haifa", "7/27/2023", "7/29/2023");
        app.getSearch().submitSearchForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getSearch().isSearchSuccess());
    }

    @Test
    public void searchCarTestPositiveDayPicker(){
        app.getSearch().fillSearchFormDayPicker("Tel Aviv", "7/24/2023", "7/30/2023");
        app.getSearch().submitSearchForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getSearch().isSearchSuccess());
    }

    @Test
    public void searchCarTestPositiveMonthPicker(){
        app.getSearch().fillSearchFormMonthPicker("Paris", "7/24/2023", "10/21/2023");
        app.getSearch().submitSearchForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getSearch().isSearchSuccess());
    }

    @Test
    public void searchCarTestPositiveYearsPicker(){
        app.getSearch().fillSearchFormYearsPicker("Berlin", "12/11/2023", "01/21/2024");
        app.getSearch().submitSearchForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getSearch().isSearchSuccess());
    }

}
