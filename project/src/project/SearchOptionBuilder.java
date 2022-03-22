package project;

public class SearchOptionBuilder {
    private final Searcher searcher;

    public SearchOptionBuilder(){
        searcher = new Searcher();
    }

    public SearchOptionBuilder(String _category, String _searchOption, String reserved){
        searcher = new Searcher();
        changeSearchStrategy(_category, _searchOption, reserved);
    }

    public void changeSearchStrategy(String _category, String _searchOption, String reserved){
        if(_category.compareTo("employeeNum") == 0){
            searcher.setSearchStrategy(new NumberSearchStrategy());
        }
        else if(_category.compareTo("name") == 0){
            if(_searchOption.compareTo("-f") == 0){
                searcher.setSearchStrategy(new FirstNameSearchStrategy());
                return;
            }
            if(_searchOption.compareTo("-l") == 0){
                searcher.setSearchStrategy(new LastNameSearchStrategy());
                return;
            }
            searcher.setSearchStrategy(new FullNameSearchStrategy());
            return;
        }
        else if(_category.compareTo("cl") == 0){
            searcher.setSearchStrategy(new CLSearchStrategy());
            return;
        }
        else if(_category.compareTo("phoneNum") == 0){
            if(_searchOption.compareTo("-m") == 0){
                searcher.setSearchStrategy(new MiddlePhoneSearchStrategy());
                return;
            }
            if(_searchOption.compareTo("-l") == 0){
                searcher.setSearchStrategy(new LastPhoneSearchStrategy());
                return;
            }
            searcher.setSearchStrategy(new FullPhoneSearchStrategy());
            return;
        }
        else if(_category.compareTo("birthday") == 0){
            if(_searchOption.compareTo("-y") == 0){
                searcher.setSearchStrategy(new YearBirthSearchStrategy());
                return;
            }
            if(_searchOption.compareTo("-m") == 0){
                searcher.setSearchStrategy(new MonthBirthSearchStrategy());
                return;
            }
            if(_searchOption.compareTo("-d") == 0){
                searcher.setSearchStrategy(new DayBirthSearchStrategy());
                return;
            }
            searcher.setSearchStrategy(new FullBirthSearchStrategy());
            return;
        }
        else if(_category.compareTo("certi") == 0){
            searcher.setSearchStrategy(new CertiSearchStrategy());
            return;
        }
        searcher.setSearchStrategy(new NumberSearchStrategy());
    }

    public Searcher getSearcher(){
        return searcher;
    }
}
