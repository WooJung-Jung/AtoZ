package project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeNameSearchStrategyTest {

    EmployeeNameSearchStrategy strategy = mock(EmployeeNameSearchStrategy.class);

    @Test
    void CallNameSearch_Mock_Method() {
        when(strategy.Search(new HashMap<>(), "WooJung")).thenReturn(new ArrayList<Employee>(){{
            add(new Employee(1));
            add(new Employee(2));
            add(new Employee(3));
        }});

        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(1));
            add(new Employee(2));
            add(new Employee(3));
        }}.toArray(), strategy.Search(new HashMap<>(), "WooJung").toArray());
    }

    @Test
    void CallNameSearch_Obj_Method() {
        EmployeeNameSearchStrategy obj = new EmployeeNameSearchStrategy();

        ArrayList<Employee> result = obj.Search(new HashMap<>(), "WooJung");
        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(1));
            add(new Employee(2));
            add(new Employee(3));
        }}.toArray(), result.toArray());
    }
}