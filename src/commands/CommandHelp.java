package commands;

import player.Player;
import zone.Zone;

public class CommandHelp extends Command {

    private CommandRegistry registry;

    public CommandHelp(CommandRegistry registry) {
        super("help", "Display commands");
        this.registry = registry;
    }

    @Override
    public void execute(Player player, Zone zone) {
        
        String result = registry.afficherCommandes();
        System.out.println(result);

    }

}