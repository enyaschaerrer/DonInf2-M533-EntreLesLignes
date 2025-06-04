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

        if (!player.getInventaire().contains("Crystal")) {
            System.out.println("You don't have the Crystal. It's impossible to teleport.");
            return;
        }

        if (args.length < 2) {
            System.out.println("Usage : teleport <nom-de-zone>");
            return;
        }

        String zoneName = args[1];
        Zone destination = game.getZoneByName(zoneName); // Assure-toi que Game possède cette méthode

        if (destination == null) {
            System.out.println("Zone unknown : " + zoneName);
            return;
        }

        if (!player.hasVisitedZone(zoneName)) {
            System.out.println("You haven't visited this zone yet.");
            return;
        }

        player.setCurrentZone(destination);
        System.out.println("Teleportation to : " + destination.getName());
    }
}
