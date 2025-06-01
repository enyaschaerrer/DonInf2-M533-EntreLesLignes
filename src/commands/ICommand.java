package commands;
import main.Game;

public interface ICommand {
    void execute(Game game, String[] args);
    String getVerb();                          
    String getDescription();                   
}