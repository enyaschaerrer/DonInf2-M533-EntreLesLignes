package commands;

import java.util.List;

import main.Game;
import objet.Key;
import objet.Letter;
import objet.Objet;
import player.Player;
import zone.Zone;

public class CommandInspect extends Command {

    public CommandInspect() {
        super("inspect", "Command to inspect an object.");
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
