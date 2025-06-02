package commands;

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

        Player player = game.getPlayer(); // récupère le joueur
        Zone currentZone = player.getCurrentZone(); // zone où il se trouve
        String objectName = args[0];
        Objet object = player.getCurrentZone().getObjetByName(objectName); // cherche l'objet dans l'inventaire

        if (object instanceof Key) {
            Key k = (Key) object;
            System.out.println("The object is a key for the area : " + k.getZoneItUnlocks().getName());
        } else if (object instanceof Letter) {
            System.out.println("The object is a letter for the area : " + object.getZone().getName());
        }
    }
}
