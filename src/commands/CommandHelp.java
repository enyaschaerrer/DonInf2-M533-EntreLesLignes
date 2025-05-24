package commands;

import main.Game;
import player.Player;
import zone.Zone;

public class CommandHelp extends Command {

    private CommandRegistry registry;

    public CommandHelp(CommandRegistry registry) {
        super("help", "Display commands");
        this.registry = registry;
    }

    @Override
    public void execute(Game game, String[] args) {
        
        String result = registry.afficherCommandes();
        System.out.println(result);

    }

}