package commands;

import main.Game;
import objet.Objet;
import player.Player;
import objet.Key;

public class CommandUse extends Command {

    public CommandUse() {
        super("use", "Use an object");
    }

    @Override
    public void execute(Game game, String[] args) {

        Player player = game.getPlayer(); // récupère le joueur
        String objectName = args[0];

        Objet object = player.getInventaire().getLastObjectByName(objectName); // cherche l'objet dans la zone

        if (object instanceof Key) {
            Key key = (Key) object;
            key.unlockZone(key.getZoneItUnlocks());;
        }

    }
}