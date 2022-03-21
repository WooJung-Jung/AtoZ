package project;

import java.util.ArrayList;

public class Displayer {
    private DisplayStrategy strategy;

    public void Display(String Cmd, ArrayList<Employee> employees){
        strategy.Display(Cmd, employees);
    }

    public void setDisplayStrategy(DisplayStrategy _strategy){
        strategy = _strategy;
    }
}
