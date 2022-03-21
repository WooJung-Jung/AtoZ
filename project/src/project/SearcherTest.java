package project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SearcherTest {

    EmployeeNameSearchStrategy employeeNameSearchStrategy = mock(EmployeeNameSearchStrategy.class);
    EmployeeNumberSearchStrategy employeeNumberSearchStrategy = mock(EmployeeNumberSearchStrategy.class);

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void NameSearch_Mock_Test() {
        Searcher searcher = new Searcher();
        when(employeeNameSearchStrategy.Search(new HashMap<>(), "WooJung")).thenReturn(new ArrayList<Employee>(){{
            add(new Employee(1));
            add(new Employee(2));
            add(new Employee(3));
        }});
        searcher.setSearchStrategy(employeeNameSearchStrategy);
        ArrayList<Employee> result = searcher.Search(new HashMap<>(), "WooJung");

        verify(employeeNameSearchStrategy,times(1)).Search(new HashMap<>(), "WooJung");
        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(1));
            add(new Employee(2));
            add(new Employee(3));
        }}.toArray(), result.toArray());
    }

    @Test
    void NumberSearch_Mock_Test() {
        Searcher searcher = new Searcher();
        when(employeeNumberSearchStrategy.Search(new HashMap<>(), "WooJung")).thenReturn(new ArrayList<Employee>(){{
            add(new Employee(3));
            add(new Employee(2));
            add(new Employee(1));
        }});
        searcher.setSearchStrategy(employeeNumberSearchStrategy);
        ArrayList<Employee> result = searcher.Search(new HashMap<>(), "WooJung");

        verify(employeeNumberSearchStrategy,times(1)).Search(new HashMap<>(), "WooJung");
        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(3));
            add(new Employee(2));
            add(new Employee(1));
        }}.toArray(), result.toArray());
    }

    @Test
    void NameSearch_Obj_Test() {
        Searcher searcher = new Searcher();

        searcher.setSearchStrategy(new EmployeeNameSearchStrategy());
        ArrayList<Employee> result = searcher.Search(new HashMap<>(), "WooJung");

        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(1));
            add(new Employee(2));
            add(new Employee(3));
        }}.toArray(), result.toArray());
    }

    @Test
    void NumberSearch_Obj_Test() {
        Searcher searcher = new Searcher();

        searcher.setSearchStrategy(new EmployeeNumberSearchStrategy());
        ArrayList<Employee> result = searcher.Search(new HashMap<>(), "WooJung");

        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(3));
            add(new Employee(2));
            add(new Employee(1));
        }}.toArray(), result.toArray());
    }

    @Test
    void setNameSearchStrategy_Obj_Test() {
        try{
            Searcher searcher = new Searcher();
            EmployeeNameSearchStrategy employeeNameSearchStrategy = new EmployeeNameSearchStrategy();

            Field field = searcher.getClass().getDeclaredField("strategy");
            field.setAccessible(true);

            searcher.setSearchStrategy(employeeNameSearchStrategy);
            EmployeeNameSearchStrategy strategy = (EmployeeNameSearchStrategy)field.get(searcher);

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
            EmployeeNumberSearchStrategy employeeNumberSearchStrategy = new EmployeeNumberSearchStrategy();

            Field field = searcher.getClass().getDeclaredField("strategy");
            field.setAccessible(true);

            searcher.setSearchStrategy(employeeNumberSearchStrategy);
            EmployeeNumberSearchStrategy strategy = (EmployeeNumberSearchStrategy)field.get(searcher);

            assertEquals(employeeNumberSearchStrategy, strategy);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}