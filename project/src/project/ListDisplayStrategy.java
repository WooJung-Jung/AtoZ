package project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        String emp1Num;
        String emp2Num;

        if(emp1.getEntryYear() < 69) emp1Num = String.format("20%08d", emp1.getEmployeeNum());
        else emp1Num = String.format("19%08d", emp1.getEmployeeNum());

        if(emp2.getEntryYear() < 69) emp2Num = String.format("20%08d", emp2.getEmployeeNum());
        else emp2Num = String.format("19%08d", emp2.getEmployeeNum());

        return emp1Num.compareTo(emp2Num);
    }
}

public class ListDisplayStrategy implements DisplayStrategy{

    @Override
    public String Display(String Cmd, ArrayList<Employee> employees) {
        int cnt = 0;
        String ret = "";

        if(employees.size() == 0) {
            return Cmd + ",NONE" + "\r\n";
        }

        employees.sort(new EmployeeComparator());
        for(Employee item : employees) {
            ret += Cmd + "," + item.print() + "\r\n";
            if(++cnt == 5){
                break;
            }
        }

        return ret;
    }
}
