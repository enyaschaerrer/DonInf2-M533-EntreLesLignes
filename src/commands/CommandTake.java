package commands;

import main.Game;
import objet.Letter;
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
            System.out.println("You picked up a " + objectName + " in the area : " + object.getZone().getName());

            if (object instanceof Letter) {
                Letter l = (Letter) object;
                System.out.println(l.getEnigme().getQuestion());
                System.out.println(new CommandSay().description);
            }

        } else {
            System.out.println("There is no object here with this name.");
        }

    }
}