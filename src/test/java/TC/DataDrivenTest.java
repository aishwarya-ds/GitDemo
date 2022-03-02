package TC;

import com.qa.utility.DataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class DataDrivenTest {

    public static void main(String args[]) throws IOException {
        DataDriven d = new DataDriven();
        ArrayList data = d.getData("sales");

        data.stream().forEach(s->System.out.println(s));

    }
}
