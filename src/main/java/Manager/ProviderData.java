package Manager;

import Models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.*;

public class ProviderData {
    @DataProvider
    public Iterator<Object[]> userDTO() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!")
        });
        list.add(new Object[]{new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!")
        });
        list.add(new Object[]{new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!")
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userDtoCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/reg_dataset.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(";");
            list.add(new Object[]{
                    new User().withName(split[0]).withLastName(split[1])
                            .withEmail(split[2]).withPassword(split[3])});
        line = reader.readLine();
        }
        return list.iterator();
    }
}
