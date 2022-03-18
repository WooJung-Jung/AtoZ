package project;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

public class EmployeeInfoMgr {
    public boolean add(HashMap<Integer, Employee> employeeHashMap, String commandData) {
        try {
            String[] params = commandData.split(",");
            if (params.length != 6) return false;

            Employee employee = new Employee(params[0], params[1], params[2], params[3], params[4], params[5]);
            employeeHashMap.put(employee.getEmployeeNum(), employee);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public List<Employee> delete(HashMap<Integer,Employee> employeeHashMap, Option2 option2) {
        List<Employee> employeeList = option2.execute(employeeHashMap);
        for(Employee employee : employeeList) {
            employeeHashMap.remove(employee.getEmployeeNum());
        }
        return employeeList;
    }

}
