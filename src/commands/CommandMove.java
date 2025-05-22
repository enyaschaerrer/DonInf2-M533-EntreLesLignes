package commands;

import player.Player;
import worldmap.WorldMap;
import zone.Zone;

public class CommandMove extends Command {
    private String direction;
    private WorldMap worldMap;
    private Zone[][] zones = worldMap.getZones();

    public CommandMove(String direction, WorldMap worldMap) {
        super("move", "Choose to move forward, backwards, left or right.");
        this.direction = direction;
        this.worldMap = worldMap;

        if (!(direction.equals("left") || direction.equals("right") || direction.equals("top")
                || direction.equals("bottom"))) {
            System.out.println("The direction isn't valid.");
        } else {
            this.direction = direction;
        }
    }

    @Override
    public void execute(Player player, Zone currentZone) {
        int row = player.getRow();
        int column = player.getColumn();

        if (this.direction.equals("top") && row != zones.length - 1) { // pas sur que ca marche, suivant cmt on affiche
                                                                       // le tableau
            int newRow = row + 1;
            worldMap.setPlayerZone(player, newRow, column);
            System.out.println(worldMap.getPlayerZone(player));

        } else if (this.direction.equals("bottom") && row != 0) {
            int newRow = row - 1;
            worldMap.setPlayerZone(player, newRow, column);
            System.out.println(worldMap.getPlayerZone(player));

        } else if (this.direction.equals("left") && column != 0) {
            int newColumn = column - 1;
            worldMap.setPlayerZone(player, row, newColumn);
            System.out.println(worldMap.getPlayerZone(player));

        } else if (this.direction.equals("right") && column != zones[0].length - 1) {
            int newColumn = column + 1;
            worldMap.setPlayerZone(player, row, newColumn);
            System.out.println(worldMap.getPlayerZone(player));

        } else {
            System.out.println("Ton mouvement ne joue pas, tu es toujours en " + worldMap.getPlayerZone(player));
        }

    }

}
