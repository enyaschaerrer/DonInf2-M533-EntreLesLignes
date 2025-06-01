package commands;

import main.Game;

public class CommandHelp extends Command {

    private CommandRegistry registry;

    public CommandHelp(CommandRegistry registry) {
        super("help", "Displays all the commands available.");
        this.registry = registry;
    }

    @Override
    public void execute(Game game, String[] args) {
        
        String result = registry.afficherCommandes();
        System.out.println(result);

    }

}