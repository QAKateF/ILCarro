package Manager;

import Models.User;
import org.testng.annotations.DataProvider;

import java.util.*;

public class ProviderData {
    @DataProvider
    public Iterator<Object[]> userDTO() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!")
        });
        list.add(new Object[]{new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!")
        });
        list.add(new Object[]{new User().withEmail("qa38@mail.mn").withPassword("Ghjk1234!")
        });
        return list.iterator();
    }
}
