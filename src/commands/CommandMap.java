package commands;

import zone.Zone;
import worldmap.WorldMap;
import main.Game;
import player.Player;
import utils.Array2Dprinter;
import utils.IPrintable;

public class CommandMap extends Command {

    public CommandMap() {
        super("map", "Displays the map.");
    }

    @Override
    public void execute(Game game, String[] args) {
        WorldMap worldMap = game.getWorldMap(); 
        Player player = game.getPlayer();       

        Zone[][] zones = worldMap.getZones();

        IPrintable[][] printableMap = new IPrintable[zones.length][zones[0].length];
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[i].length; j++) {
                printableMap[i][j] = zones[i][j];
            }
        }

        int playerRow = player.getCurrentZone().getX();
        int playerCol = player.getCurrentZone().getY();

        // affiche carte avec la position du joueur
        System.out.println(Array2Dprinter.print2DArray(printableMap, playerRow, playerCol));
    }
}
