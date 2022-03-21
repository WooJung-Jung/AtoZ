package project;

import java.util.ArrayList;
import java.util.HashMap;

public class Searcher {
    private SearchStrategy strategy;

    public ArrayList<Employee> Search(HashMap<Integer, Employee> table, String target){
        return strategy.Search(table, target);
    }

    public void setSearchStrategy(SearchStrategy _strategy){
        strategy = _strategy;
    }
}
