package commands;

import java.util.List;

import main.Game;
import objet.Cle;
import objet.Lettre;
import objet.Objet;
import player.Player;
import zone.Zone;

public class CommandInspect extends Command {

    private Objet object;

    public CommandInspect(Objet object) {
        super("inspect", "Command to inspect an object.");
        this.object = object;
    }

    @Override
    public void execute(Game game, String[] args) {
        if (this.object instanceof Cle) {
            System.out.println("The object is a key for the area : " + this.object.getZone());
        } else if (this.object instanceof Lettre) {
            System.out.println("The object is a letter for the area : " + this.object.getZone());
        }

        Player player = game.getPlayer();

        for (Objet obj : player.getInventaire().getObjets()) {
            if (obj.getClass().getSimpleName().equalsIgnoreCase(objectName)) {
                System.out.println(obj.inspect(obj));
                return;
            }
        }

        System.out.println("You don’t have that object.");
    }

    // la je veux faire une methode pour acceder a la liste
    public List<Objet> getObjets() {
        return objets;
    }

}
