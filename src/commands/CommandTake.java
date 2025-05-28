package commands;

import main.Game;
import objet.Objet;
import player.Player;
import zone.Zone;

public class CommandTake extends Command {

    public CommandTake() {
        super("take", "Pick up an object.");
    }

    @Override
    public void execute(Game game, String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify the name of the object to take.");
            return;
        }
        Player player = game.getPlayer(); // récupère le joueur
        Zone currentZone = player.getCurrentZone(); // zone où il se trouve
        String objectName = args[0];

        Objet object = currentZone.getObjetByName(objectName); // cherche l'objet dans la zone

        if (object != null) {
            player.getInventaire().addObjet(object); // ajoute à l'inventaire
            currentZone.removeObjet(object); // enlève de la zone
            System.out.println("You picked up a " + objectName + " for the area : " + object.getZone().getName());
        } else {
            System.out.println("There is no object here with this name.");
        }
    }
}