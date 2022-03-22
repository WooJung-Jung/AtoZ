package project;

import java.util.ArrayList;
import java.util.HashMap;

public class FullPhoneSearchStrategy implements SearchStrategy{
    @Override
    public ArrayList<Employee> Search(HashMap<Integer, Employee> table, String target) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        for (Integer item : table.keySet()) {
            if (target.equals((table.get(item).getPhoneNum()))) {
                employees.add(table.get(item));
            }
        }
        return employees;
    }
}
