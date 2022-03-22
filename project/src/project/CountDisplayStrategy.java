package project;

import java.util.ArrayList;

public class CountDisplayStrategy implements DisplayStrategy{
    @Override
    public String Display(String Cmd, ArrayList<Employee> employees) {
        if(employees.size() == 0) {
            return Cmd + ",NONE" + "\r\n";
        }
        
        return Cmd + "," + employees.size() + "\r\n";
    }
}
