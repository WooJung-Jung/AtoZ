package project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeNumberSearchStrategyTest {

    EmployeeNumberSearchStrategy strategy = mock(EmployeeNumberSearchStrategy.class);

    @Test
    void CallNumberSearch_Mock_Method() {
        when(strategy.Search(new HashMap<>(), "WooJung")).thenReturn(new ArrayList<Employee>(){{
            add(new Employee(3));
            add(new Employee(2));
            add(new Employee(1));
        }});

        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(3));
            add(new Employee(2));
            add(new Employee(1));
        }}.toArray(), strategy.Search(new HashMap<>(), "WooJung").toArray());
    }

    @Test
    void CallNumberSearch_Obj_Method() {
        EmployeeNumberSearchStrategy obj = new EmployeeNumberSearchStrategy();

        ArrayList<Employee> result = obj.Search(new HashMap<>(), "WooJung");
        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(3));
            add(new Employee(2));
            add(new Employee(1));
        }}.toArray(), result.toArray());
    }
}