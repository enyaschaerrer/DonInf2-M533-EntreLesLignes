package commands;
import main.Game;

public class CommandUse extends Command {
    private String objectName;

    public CommandUse(String objectName) {
        super("use", "Be able to use an object");
        this.objectName = objectName;
    }

    @Override
    public void execute(Game game, String[] args) {
    }
}