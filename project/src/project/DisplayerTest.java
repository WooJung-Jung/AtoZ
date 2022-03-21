package project;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class DisplayerTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    CountDisplayStrategy countDisplayStrategy = mock(CountDisplayStrategy.class);
    ListDisplayStrategy listDisplayStrategy = mock(ListDisplayStrategy.class);

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void CountDisplay_Mock_Test() {
        Displayer player = new Displayer();
        doNothing().when(countDisplayStrategy).Display("SCH", new ArrayList<>());
        player.setDisplayStrategy(countDisplayStrategy);
        player.Display("SCH", new ArrayList<>());
        verify(countDisplayStrategy,times(1)).Display("SCH", new ArrayList<>());
    }

    @Test
    void ListDisplay_Mock_Test() {
        Displayer player = new Displayer();
        doNothing().when(listDisplayStrategy).Display("SCH", new ArrayList<>());
        player.setDisplayStrategy(listDisplayStrategy);
        player.Display("SCH", new ArrayList<>());
        verify(listDisplayStrategy,times(1)).Display("SCH", new ArrayList<>());
    }

    @Test
    void CountDisplay_Obj_Test() {
        try {
            Displayer player = new Displayer();

            player.setDisplayStrategy(new CountDisplayStrategy());
            ArrayList<Employee> tmp = new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
                add(new Employee("18028688", "WooJung Jang", "CL2", "010-1674-1674", "19800808", "PRO"));
            }};
            player.Display("SCH", tmp);
            assertEquals("SCH,2", outputStreamCaptor.toString().trim());
        }
        catch (ParseException e){

        }

    }

    @Test
    void ListDisplay_Obj_Test() {
        try {
            Displayer player = new Displayer();

            player.setDisplayStrategy(new ListDisplayStrategy());
            ArrayList<Employee> tmp = new ArrayList<Employee>(){{
                add(new Employee("18028689", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
                add(new Employee("18028688", "WooJung Jang", "CL2", "010-1674-1674", "19800808", "PRO"));
                add(new Employee("18028682", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
                add(new Employee("18028695", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
                add(new Employee("18028700", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }};

            player.Display("SCH", tmp);
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
    void setListDisplayStrategy_Obj_Test() {

        try{
            Displayer player = new Displayer();
            ListDisplayStrategy listDisplayStrategy = new ListDisplayStrategy();

            Field field = player.getClass().getDeclaredField("strategy");
            field.setAccessible(true);

            player.setDisplayStrategy(listDisplayStrategy);
            DisplayStrategy strategy = (DisplayStrategy)field.get(player);

            assertEquals(listDisplayStrategy, strategy);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

    @Test
    void setCountDisplayStrategy_Obj_Test() {

        try{
            Displayer player = new Displayer();
            CountDisplayStrategy countDisplayStrategy = new CountDisplayStrategy();

            Field field = player.getClass().getDeclaredField("strategy");
            field.setAccessible(true);

            player.setDisplayStrategy(countDisplayStrategy);
            DisplayStrategy strategy = (DisplayStrategy)field.get(player);

            assertEquals(countDisplayStrategy, strategy);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}