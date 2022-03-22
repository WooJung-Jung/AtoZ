package project;

import java.util.ArrayList;
import java.util.HashMap;

public class NumberSearchStrategy implements SearchStrategy{
    @Override
    public ArrayList<Employee> Search(HashMap<Integer, Employee> table, String target) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        if (table.containsKey(Integer.parseInt(target)))
            employees.add(table.get(Integer.parseInt(target)));
        return employees;
    }
}
