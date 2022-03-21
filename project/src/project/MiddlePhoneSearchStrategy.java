package project;

import java.util.ArrayList;
import java.util.HashMap;

public class MiddlePhoneSearchStrategy implements SearchStrategy{
    @Override
    public ArrayList<Employee> Search(HashMap<Integer, Employee> table, String target) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        for (Integer item : table.keySet()) {
            if (target.equals((table.get(item).getPhoneNum().split("-")[1]))) {
                employees.add(employees.get(item));
            }
        }
        return employees;
    }
}
