package project;

import java.util.ArrayList;

public class CountDisplayStrategy implements DisplayStrategy{
    @Override
    public void Display(String Cmd, ArrayList<Employee> employees) {
        if(employees.size() == 0) {
            System.out.println(Cmd + ",NONE");
            return;
        }
        System.out.println(Cmd + "," + employees.size());
    }
}
