package project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumberSearchStrategyTest {

    NumberSearchStrategy strategy = mock(NumberSearchStrategy.class);

    @Test
    void CallNumberSearch_Mock_Method() {
        try{
            when(strategy.Search(new HashMap<>(), "18028687")).thenReturn(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }});

            assertArrayEquals(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }}.toArray(), strategy.Search(new HashMap<>(), "18028687").toArray());
        }
        catch (ParseException e){

        }
    }

    @Test
    void CallNumberSearch_Obj_Method() {
        try {
            NumberSearchStrategy obj = new NumberSearchStrategy();
            HashMap<Integer, Employee> tmp = new HashMap<>();
            tmp.put(18028687, new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            tmp.put(18028688, new Employee("18028688", "WooJung Jang", "CL2", "010-1674-1674", "19800808", "PRO"));

            ArrayList<Employee> result = obj.Search(tmp, "18028687");
            assertArrayEquals(new ArrayList<Employee>(){{
                add(new Employee("18028687", "WooJung Jung", "CL2", "010-2725-1674", "19000808", "PRO"));
            }}.toArray(), result.toArray());
        }
        catch (ParseException e){

        }
    }
}