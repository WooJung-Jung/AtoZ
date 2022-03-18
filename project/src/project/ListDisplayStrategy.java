package project;

import java.util.ArrayList;

public class ListDisplayStrategy implements DisplayStrategy{

    @Override
    public void Display(ArrayList<Employee> employees) {
        System.out.println("Call ListDisplay");
    }
}
