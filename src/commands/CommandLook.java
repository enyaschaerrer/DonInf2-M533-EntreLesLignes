package commands;

import main.Game;
import objet.Objet;
import zone.Zone;

public class CommandLook extends Command {

    private Zone zone;

    public CommandLook(Game game) {
        super("look", "Displays objects in the current zone.");
    }

    @Override
    public void execute(Game game, String[] args) {

        this.zone = game.getPlayer().getCurrentZone();

        if (this.zone.getObjets().isEmpty()) {
            System.out.println(zone.getDescription());

        } else {
            System.out.println("In your game area there is ");

            for (Objet obj : this.zone.getObjets()) {
                System.out.println(obj.inspect(obj)); // donne tous les objets pour la zone.
            }

        }
    }

}