package commands;
import main.Game;
import player.Player;
import zone.Zone;

public abstract class Command implements ICommand {
    protected String verb; // unique
    protected String description;

    public Command(String verb, String description) {
        this.verb = verb;
        this.description = description;
    }

    public String getVerb() {
        return verb;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(Game game, String[] args);
    
}