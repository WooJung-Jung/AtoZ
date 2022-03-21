package project;

import java.util.HashMap;

public class EmployeeInfo {
    private HashMap<Integer,Employee> employeeHashMap = new HashMap<>();

    public HashMap<Integer,Employee> getInfoTable(String codition) {
        return employeeHashMap;
    }
}
