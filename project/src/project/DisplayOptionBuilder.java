package project;

public class DisplayOptionBuilder {

    private final Displayer player;

    public DisplayOptionBuilder(){
        player = new Displayer();
    }

    public DisplayOptionBuilder(boolean isListDisplay){
        player = new Displayer();
        changeDisplayStrategy(isListDisplay);
    }

    public void changeDisplayStrategy(boolean isListDisplay){
        if(isListDisplay){
            player.setDisplayStrategy(new ListDisplayStrategy());
            return;
        }
        player.setDisplayStrategy(new CountDisplayStrategy());
    }

    public Displayer getPlayer(){
        return player;
    }
}
