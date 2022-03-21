package project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SearchOptionBuilderTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void changeSearchStrategy_EmployeeNumber_Obj_Test() {
        try {
            SearchOptionBuilder searchOptionBuilder = new SearchOptionBuilder();
            searchOptionBuilder.changeSearchStrategy("employeeNum", "", "");
            Searcher obj = searchOptionBuilder.getSearcher();

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

    @Test
    void changeSearchStrategy_EmployeeName_Obj_Test() {

        try {
            SearchOptionBuilder searchOptionBuilder = new SearchOptionBuilder();
            searchOptionBuilder.changeSearchStrategy("name", "", "");
            Searcher obj = searchOptionBuilder.getSearcher();

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