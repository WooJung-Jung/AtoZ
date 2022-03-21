package project;

import java.text.ParseException;
import java.util.ArrayList;
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

    public List<Employee> delete(HashMap<Integer,Employee> employeeHashMap, SearchStrategy searcher, String commandData) {
        String[] params = commandData.split(",");
        if (params.length != 2) return new ArrayList<Employee>();

        ArrayList<Employee> employeeList = searcher.Search(employeeHashMap, params[1]);
        for(Employee employee : employeeList) {
            employeeHashMap.remove(employee.getEmployeeNum());
        }
        return employeeList;
    }

    public List<Employee> search(HashMap<Integer,Employee> employeeHashMap, SearchStrategy searcher, String commandData) {
        String[] params = commandData.split(",");
        if (params.length != 2) return new ArrayList<Employee>();

        return searcher.Search(employeeHashMap, params[1]);
    }

    public List<Employee> modify(HashMap<Integer, Employee> employeeHashMap, SearchStrategy searcher, String commandData) throws Exception {
        String[] param = commandData.split(",");
        if (param.length != 4) return new ArrayList<Employee>();

        List<Employee> employeeList = searcher.Search(employeeHashMap, param[1]);
        for(Employee employee : employeeList) {
            employeeHashMap.get(employee.getEmployeeNum()).modify(param[2], param[3]);
        }
        return employeeList;
    }
}
