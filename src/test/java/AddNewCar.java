import Models.Car;
import Models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase{
    @BeforeMethod
public void precondition(){
        if(app.getUser().isLogged() == false){
            app.getUser().login(new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!"));
        }
    }

    @Test
    public void addNewCarPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Car car = Car.builder().location("Tel Aviv")
                .manufacture("KIA")
                .model("Sport")
                .year("2023")
                .fuel("Petrol")
                .seats("5")
                .carClass("B")
                .carRegNumber("120-264-" + i)
                .price("300")
                .about("")
                .build();
    }
}
