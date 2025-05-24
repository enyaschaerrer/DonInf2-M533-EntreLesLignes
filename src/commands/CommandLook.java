package commands;

import main.Game;
import objet.Objet;
import player.Player;
import zone.Zone;

public class CommandLook extends Command {

    private Zone zone;

    public CommandLook(Zone zone) {
        super("look", "Know what objects are in the current zone.");
        this.zone = zone;
    }

    // affiche les objets de la zone dans laquelle le joueur se trouve
    @Override
    public void execute(Game game, String[] args) {

        if (game.getObjects().isEmpty()) {
            System.out.println(zone.getDescription());
            
        } else {
            System.out.println("Dans ta zone se trouve ");

            for (Objet obj : game.getObjects()) {
                if (obj.getZone().equals(this.zone)) {
                    System.out.println("un(e) " + obj.inspect(obj));
                }
            }
        }
    }

}