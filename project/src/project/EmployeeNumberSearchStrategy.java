package project;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeNumberSearchStrategy implements SearchStrategy{
    @Override
    public ArrayList<Employee> Search(HashMap<Integer, Employee> table, String target) {
        return new ArrayList<Employee>(){{
            add(new Employee(3));
            add(new Employee(2));
            add(new Employee(1));
        }};
    }
}
