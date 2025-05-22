package commands;
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

    // ?
    protected boolean canExecute(Player player, Zone zone) {
        return true; 
    }

    public abstract void execute(Player player, Zone zone);
}