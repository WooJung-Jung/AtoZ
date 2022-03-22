package project;

import java.util.ArrayList;
import java.util.HashMap;

public class YearBirthSearchStrategy implements SearchStrategy{
    @Override
    public ArrayList<Employee> Search(HashMap<Integer, Employee> table, String target) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        for (Integer item : table.keySet()) {
            if (target.equals((table.get(item).getBirthday().getYear()))) {
                employees.add(employees.get(item));
            }
        }
        return employees;
    }
}