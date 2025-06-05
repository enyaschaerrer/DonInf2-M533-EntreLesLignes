package commands;

import main.Game;
import zone.Zone;
import player.Player;
import worldmap.WorldMap;

public class CommandMove extends Command {

    public CommandMove() {
        super("move", "Usage: move <north|south|east|west>");
    }

    @Override
    public void execute(Game game, String[] args) {

        if (args.length == 0) {

            System.out.println("Usage: move <north|south|east|west>");
            return;

        } else {

            String direction = args[0].toLowerCase();
            Player player = game.getPlayer();
            Zone currentZone = player.getCurrentZone();

            Zone targetZone = WorldMap.getAdjacentZone(currentZone, direction);

            if (targetZone == null) {
                System.out.println("Impossible to move there.");

            } else if (targetZone.isLocked()) {
                System.out.println("Zone locked.");

            } else {
                player.setCurrentZone(targetZone); // met à jour la position du joueur
                player.addVisitedZone(targetZone);
                System.out.println("You moved to: " + targetZone.getName());
                System.out.println(targetZone.getDescription());
            }
        }
    }
}
