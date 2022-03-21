package project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DisplayOptionBuilderTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void changeDisplayStrategy_ListDisplay_Obj_Test() {
        try {
            DisplayOptionBuilder displayOptionBuilder = new DisplayOptionBuilder();
            displayOptionBuilder.changeDisplayStrategy("ListDisplay");
            Displayer obj = displayOptionBuilder.getPlayer();

            ArrayList<Employee> tmp = new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
                add(new Employee("18028688", "WooJung Jang", "CL2", "010-1674-1674", "19800808", "PRO"));
            }};
            obj.Display("SCH", tmp);

            String str = "";
            int cnt = 0;
            for(Employee item : tmp){
                if(cnt++ != 0){
                    str += "\r\n";
                }
                str += "SCH" + "," + item.getEmployeeNum() + "," + item.getFirstName() + "," + item.getLastName() + "," + item.getCl() + "," + item.getPhoneNum() + "," + item.getBirthday() + "," + item.getCerti();
            }
            assertEquals(str, outputStreamCaptor.toString().trim());
        }
        catch (ParseException e){

        }

    }

    @Test
    void changeDisplayStrategy_CountDisplay_Obj_Test() {
        try {
            DisplayOptionBuilder displayOptionBuilder = new DisplayOptionBuilder();
            displayOptionBuilder.changeDisplayStrategy("CountDisplay");
            Displayer obj = displayOptionBuilder.getPlayer();

            ArrayList<Employee> tmp = new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
                add(new Employee("18028688", "WooJung Jang", "CL2", "010-1674-1674", "19800808", "PRO"));
            }};
            obj.Display("SCH", tmp);
            assertEquals("SCH,2", outputStreamCaptor.toString().trim());
        }
        catch (ParseException e){

        }

    }

}