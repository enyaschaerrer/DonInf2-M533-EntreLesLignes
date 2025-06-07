package commands;

import main.Game;
import objet.Key;
import objet.Letter;
import objet.Objet;
import player.Player;

public class CommandInspect extends Command {

    private Objet object;

    public CommandInspect() {
        super("inspect", "Command to inspect an object.");
    }

    @Override
    public void execute(Game game, String[] args) {

        Player player = game.getPlayer(); // récupère le joueur

        if (args.length == 0) {
            System.out.println("Veuillez spécifier le nom de l'objet à inspecter. Exemple : inspect Lettre");
            return;
        }

        String objectName = args[0];
        Objet object = player.getCurrentZone().getObjetByName(objectName); // cherche l'objet dans l'inventaire

         if (object == null) {
            System.out.println("Aucun objet nommé '" + objectName + "' n'est présent dans cette zone.");
            return;
        }

        if (object instanceof Key) {
            Key k = (Key) object;
            System.out.println("The object is a key for the area : " + k.getZoneItUnlocks().getName());
        } else if (object instanceof Letter) {
            Letter l = (Letter) object;
            System.out.println(
                    "The object is a letter with inside a riddle, which if solved correctly, will drop a key unlocking the "
                            + l.getEnigme().getCle().getZoneItUnlocks().getName());

        }
    }

}
