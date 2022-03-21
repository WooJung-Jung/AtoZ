package project;

import java.util.ArrayList;
import java.util.HashMap;

public class FullNameSearchStrategy implements SearchStrategy {
    @Override
    public ArrayList<Employee> Search(HashMap<Integer, Employee> table, String target) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        for(Integer i : table.keySet()) {
            if (target.equals((table.get(i).getName()))) {
                employees.add(table.get(i));
            }
        }
        return employees;
    }
}
