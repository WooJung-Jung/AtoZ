package project;

import java.util.ArrayList;

public class Displayer {
    private DisplayStrategy strategy;

    public void Display(ArrayList<Employee> employees){
        strategy.Display(employees);
    }

    public void setDisplayStrategy(DisplayStrategy _strategy){
        strategy = _strategy;
    }
}
