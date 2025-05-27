package commands;

import main.Game;

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
