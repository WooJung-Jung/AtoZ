package project;

public class DisplayOptionBuilder {

    private final Displayer player;

    public DisplayOptionBuilder(){
        player = new Displayer();
    }

    public DisplayOptionBuilder(String _displayOption){
        player = new Displayer();
        changeDisplayStrategy(_displayOption);
    }

    public void changeDisplayStrategy(String _displayOption){
        if(_displayOption.compareTo("ListDisplay") == 0){
            player.setDisplayStrategy(new ListDisplayStrategy());
            return;
        }else if(_displayOption.compareTo("CountDisplay") == 0){
            player.setDisplayStrategy(new CountDisplayStrategy());
        }
        else{
            player.setDisplayStrategy(new ListDisplayStrategy());
        }
    }

    public Displayer getPlayer(){
        return player;
    }
}
