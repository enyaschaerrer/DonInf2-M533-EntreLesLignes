package commands;

import main.Game;
import player.Player;
import zone.Zone;

public class CommandTeleport extends Command {

    public CommandTeleport() {
        super("teleport", "Teleport you to an already visited zone.");
    }

    @Override
    public void execute(Game game, String[] args) {
        Player player = game.getPlayer();

        if (args.length < 1) {
            System.out.println("Usage : teleport <nom-de-zone>");
            return;
        }

        if (!player.getInventaire().contains("Crystal")) {
            System.out.println("You don't have the Crystal. It's impossible to teleport.");
            return;
        }

        else {

            String zoneName = args[0];
            Zone destination = game.getZoneByName(zoneName);

            if (destination == null) {
                System.out.println("Zone unknown : " + zoneName);
                return;
            }

            else if (!player.hasVisitedZone(zoneName)) {
                System.out.println("You haven't visited this zone yet.");
                return;

            } else {
                player.setCurrentZone(destination);
                player.addVisitedZone(destination);
                System.out.println("Teleportation to : " + destination.getName());
            }
        }
    }
}
