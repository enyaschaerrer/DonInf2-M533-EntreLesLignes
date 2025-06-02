package commands;

import main.Game;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import player.Player;
import zone.Zone;
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

public class CommandSay extends Command {
    private String response;

    public CommandSay(String response) {
        super("say", "Answer to solve the ridle");
        this.response = response;
    }

    @Override
    public void execute(Game game, String[] args) {
        
    }
}
