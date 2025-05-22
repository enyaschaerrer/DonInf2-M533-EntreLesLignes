package commands;
import player.Player;
import zone.Zone;

public interface ICommand {
    void execute(Player player, Zone zone);  
    String getVerb();                          
    String getDescription();                   
}