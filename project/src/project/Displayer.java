package project;

import java.util.ArrayList;

public class Displayer {
    private DisplayStrategy strategy;

    public String Display(String Cmd, ArrayList<Employee> employees){
        return strategy.Display(Cmd, employees);
    }

    public void setDisplayStrategy(DisplayStrategy _strategy){
        strategy = _strategy;
    }
}
