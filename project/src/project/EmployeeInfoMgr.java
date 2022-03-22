package project;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeInfoMgr {
    public boolean add(HashMap<Integer, Employee> employeeHashMap, ArrayList<Data> commandData) {
        try {
        	Employee employee = new Employee(commandData.get(0).value, commandData.get(1).value, commandData.get(2).value
        			, commandData.get(3).value, commandData.get(4).value, commandData.get(5).value);
            employeeHashMap.put(employee.getEmployeeNum(), employee);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public List<Employee> delete(HashMap<Integer,Employee> employeeHashMap, Searcher searcher, ArrayList<Data> commandData) {
    	ArrayList<Employee> employeeList = searcher.Search(employeeHashMap, commandData.get(0).value);
        for(Employee employee : employeeList) {
            employeeHashMap.remove(employee.getEmployeeNum());
        }
        return employeeList;
    }

    public List<Employee> search(HashMap<Integer,Employee> employeeHashMap, Searcher searcher, ArrayList<Data> commandData) {
    	return searcher.Search(employeeHashMap, commandData.get(0).value);
    }

    public List<Employee> modify(HashMap<Integer, Employee> employeeHashMap, Searcher searcher, ArrayList<Data> commandData) throws Exception {
    	List<Employee> employeeList = searcher.Search(employeeHashMap, commandData.get(0).value);
        for(Employee employee : employeeList) {
        	employeeHashMap.get(employee.getEmployeeNum()).modify(commandData.get(1).column, commandData.get(1).value);
        }
        return employeeList;
    }
}
