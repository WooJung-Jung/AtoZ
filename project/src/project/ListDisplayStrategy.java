package project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int emp1Num = emp1.getEmployeeNum();
        int emp2Num = emp2.getEmployeeNum();

        if(emp1Num < 69000000) emp1Num = emp1Num*100000000;
        if(emp2Num < 69000000) emp2Num = emp2Num*100000000;
        if (emp1Num > emp2Num) {
            return 1;
        } else if (emp1Num < emp2Num) {
            return -1;
        }
        return 0;
    }
}

public class ListDisplayStrategy implements DisplayStrategy{

    @Override
    public String Display(String Cmd, ArrayList<Employee> employees) {
        int cnt = 0;
        String ret = "";
        
        if(employees.size() == 0) {
            return Cmd + ",NONE";
        }
        
        Collections.sort(employees, new EmployeeComparator());
        for(Employee item : employees) {
            ret += Cmd + "," + item.getEmployeeNum() + "," + item.getFirstName() + "," + item.getLastName() + "," + item.getCl() + "," + item.getPhoneNum() + "," + item.getBirthday() + "," + item.getCerti();
            if(++cnt == 5){
                break;
            }
        }
        
        return ret;
    }
}
