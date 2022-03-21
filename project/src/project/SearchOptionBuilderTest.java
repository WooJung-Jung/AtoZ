package project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        SearchOptionBuilder searchOptionBuilder = new SearchOptionBuilder();
        searchOptionBuilder.changeSearchStrategy("EmployeeNumber");
        Searcher obj = searchOptionBuilder.getSearcher();
        ArrayList<Employee> result = obj.Search(new HashMap<>(), "18028687");

        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(3));
            add(new Employee(2));
            add(new Employee(1));
        }}.toArray(), result.toArray());
    }

    @Test
    void changeSearchStrategy_EmployeeName_Obj_Test() {
        SearchOptionBuilder searchOptionBuilder = new SearchOptionBuilder();
        searchOptionBuilder.changeSearchStrategy("EmployeeName");
        Searcher obj = searchOptionBuilder.getSearcher();
        ArrayList<Employee> result = obj.Search(new HashMap<>(), "WooJung");

        assertArrayEquals(new ArrayList<Employee>(){{
            add(new Employee(1));
            add(new Employee(2));
            add(new Employee(3));
        }}.toArray(), result.toArray());
    }

}