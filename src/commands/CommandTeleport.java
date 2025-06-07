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
            System.out.println("Usage : teleport <name-zone>");
            return;
        }

        if (!player.getInventaire().contains("crystal")) {
            System.out.println("You don't have the crystal. It's impossible to teleport.");

            return;
        }

        String zoneName = args[0];
        Zone destination = game.getZoneByName(zoneName);

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
