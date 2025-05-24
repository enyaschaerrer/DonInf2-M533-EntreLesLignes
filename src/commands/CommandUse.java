package commands;
import main.Game;
import player.Player;
import zone.Zone;

public class CommandUse extends Command {
    private String objectName;

    public CommandUse(String objectName) {
        super("use", "Be able to use an obect");
        this.objectName = objectName;
    }

    @Override
    public void execute(Game game, String[] args) {
    }
}