package commands;
import main.Game;
<<<<<<< Updated upstream
=======
import objet.Objet;
import player.Player;
import zone.Zone;
import objet.Key;
>>>>>>> Stashed changes

public class CommandUse extends Command {
    private String objectName;

<<<<<<< Updated upstream
    public CommandUse(String objectName) {
        super("use", "Be able to use an object");
        this.objectName = objectName;
=======
    public CommandUse() {
        super("use", "Be able to use an object");
>>>>>>> Stashed changes
    }

    @Override
    public void execute(Game game, String[] args) {
    }
}