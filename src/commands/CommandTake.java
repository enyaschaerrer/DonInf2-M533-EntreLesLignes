package commands;
import main.Game;
import player.Player;
import zone.Zone;

public class CommandTake extends Command {
    private String objectName;

    public CommandTake(String objectName) {
        super("take", "Pick up an object.");
        this.objectName = objectName;
    }

    @Override
    public void execute(Game game, String[] args) {
        // ca doit mettre dans l'inventaire
    }
}