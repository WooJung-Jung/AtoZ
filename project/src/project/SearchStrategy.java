package project;

import java.util.ArrayList;
import java.util.HashMap;

public interface SearchStrategy {
    ArrayList<Employee> Search(HashMap<Integer, Employee> employeeHashMap, String target);
}
