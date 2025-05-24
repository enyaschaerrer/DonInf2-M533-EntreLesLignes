package commands;
import main.Game;
import player.Player;
import zone.Zone;

public interface ICommand {
    void execute(Game game, String[] args);
    String getVerb();                          
    String getDescription();                   
}