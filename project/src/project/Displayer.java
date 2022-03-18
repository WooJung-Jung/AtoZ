package project;

import java.util.ArrayList;

class Employee{
    public Employee(int _data){
        data = _data;
    }
    public int data;
}

public class Displayer {
    private DisplayStrategy strategy;

    public void Display(ArrayList<Employee> employees){
        strategy.Display(employees);
    }

    public void setDisplayStrategy(DisplayStrategy _strategy){
        strategy = _strategy;
    }
}
