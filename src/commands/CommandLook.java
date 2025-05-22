package commands;

import player.Player;
import zone.Zone;

public class CommandLook extends Command {
    public CommandLook() {
        super("look", "idk what to ");
    }

    // affiche les objets de la zone dans laquelle le joueur se trouve
    @Override
    public void execute(Player player, Zone zone) {

         //if object.getZone() == zone
         // liste de tous les objets qq part?
    }
}