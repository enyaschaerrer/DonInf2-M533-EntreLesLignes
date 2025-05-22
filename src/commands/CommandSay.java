package commands;

import player.Player;
import zone.Zone;

public class CommandSay extends Command {
    private String response;

    public CommandSay(String response) {
        super("say", "Answer to solve the ridle");
        this.response = response;
    }

    @Override
    public String execute(Player player, Zone zone) {
        
    }
}
