package project;

public class SearchOptionBuilder {
    private final Searcher searcher;

    public SearchOptionBuilder(){
        searcher = new Searcher();
    }

    public SearchOptionBuilder(String _searchOption){
        searcher = new Searcher();
        changeSearchStrategy(_searchOption);
    }

    public void changeSearchStrategy(String _searchOption){
        if(_searchOption.compareTo("EmployeeNumber") == 0){
            searcher.setSearchStrategy(new EmployeeNumberSearchStrategy());
            return;
        }
        searcher.setSearchStrategy(new EmployeeNameSearchStrategy());
    }

    public Searcher getSearcher(){
        return searcher;
    }
}
