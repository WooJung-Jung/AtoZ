package project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FullNameSearchStrategyTest {

    FullNameSearchStrategy strategy = mock(FullNameSearchStrategy.class);

    @Test
    void CallNameSearch_Mock_Method() {
        try {
            when(strategy.Search(new HashMap<>(), "WooJung Jung")).thenReturn(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }});

            assertArrayEquals(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }}.toArray(), strategy.Search(new HashMap<>(), "WooJung Jung").toArray());
        }
        catch (ParseException e){

        }
    }

    @Test
    void CallNameSearch_Obj_Method() {
        try {
            FullNameSearchStrategy obj = new FullNameSearchStrategy();
            HashMap<Integer, Employee> tmp = new HashMap<>();
            tmp.put(18028687, new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            tmp.put(18028688, new Employee("18028688", "WooJung Jang", "CL2", "010-1674-1674", "19800808", "PRO"));

            ArrayList<Employee> result = obj.Search(tmp, "WooJung Jung");
            assertArrayEquals(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }}.toArray(), result.toArray());
        }
        catch (ParseException e){

        }

    }
}