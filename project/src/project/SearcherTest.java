package project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SearcherTest {

    FullNameSearchStrategy employeeNameSearchStrategy = mock(FullNameSearchStrategy.class);
    NumberSearchStrategy numberSearchStrategy = mock(NumberSearchStrategy.class);

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void NameSearch_Mock_Test() {
        try {
            Searcher searcher = new Searcher();
            when(employeeNameSearchStrategy.Search(new HashMap<>(), "WooJung Jung")).thenReturn(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }});

            assertArrayEquals(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }}.toArray(), employeeNameSearchStrategy.Search(new HashMap<>(), "WooJung Jung").toArray());
        }
        catch (ParseException e){

        }
    }

    @Test
    void NumberSearch_Mock_Test() {

        try {
            Searcher searcher = new Searcher();
            when(numberSearchStrategy.Search(new HashMap<>(), "18028687")).thenReturn(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }});
            searcher.setSearchStrategy(numberSearchStrategy);
            ArrayList<Employee> result = searcher.Search(new HashMap<>(), "18028687");

            verify(numberSearchStrategy,times(1)).Search(new HashMap<>(), "18028687");
            assertArrayEquals(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }}.toArray(), result.toArray());
        }
        catch (ParseException e){

        }
    }

    @Test
    void NameSearch_Obj_Test() {
        try {
            Searcher searcher = new Searcher();
            HashMap<Integer, Employee> tmp = new HashMap<>();
            tmp.put(18028687, new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            tmp.put(18028688, new Employee("18028688", "WooJung Jang", "CL2", "010-1674-1674", "19800808", "PRO"));

            searcher.setSearchStrategy(new FullNameSearchStrategy());
            ArrayList<Employee> result = searcher.Search(tmp, "WooJung Jung");

            assertArrayEquals(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }}.toArray(), result.toArray());
        }
        catch (ParseException e){

        }
    }

    @Test
    void NumberSearch_Obj_Test() {
        try {
            Searcher searcher = new Searcher();
            HashMap<Integer, Employee> tmp = new HashMap<>();
            tmp.put(18028687, new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            tmp.put(18028688, new Employee("18028688", "WooJung Jang", "CL2", "010-1674-1674", "19800808", "PRO"));

            searcher.setSearchStrategy(new NumberSearchStrategy());
            ArrayList<Employee> result = searcher.Search(tmp, "18028687");

            assertArrayEquals(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }}.toArray(), result.toArray());
        }
        catch (ParseException e){

        }
    }

    @Test
    void setNameSearchStrategy_Obj_Test() {
        try{
            Searcher searcher = new Searcher();
            FullNameSearchStrategy employeeNameSearchStrategy = new FullNameSearchStrategy();

            Field field = searcher.getClass().getDeclaredField("strategy");
            field.setAccessible(true);

            searcher.setSearchStrategy(employeeNameSearchStrategy);
            FullNameSearchStrategy strategy = (FullNameSearchStrategy)field.get(searcher);

            assertEquals(employeeNameSearchStrategy, strategy);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }

    @Test
    void setNumberSearchStrategy_Obj_Test() {
        try{
            Searcher searcher = new Searcher();
            NumberSearchStrategy numberSearchStrategy = new NumberSearchStrategy();

            Field field = searcher.getClass().getDeclaredField("strategy");
            field.setAccessible(true);

            searcher.setSearchStrategy(numberSearchStrategy);
            NumberSearchStrategy strategy = (NumberSearchStrategy)field.get(searcher);

            assertEquals(numberSearchStrategy, strategy);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}