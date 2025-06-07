package commands;

import main.Game;
import player.Player;
import utils.Array2Dprinter;
import utils.IPrintable;
import worldmap.WorldMap;
import zone.Zone;

public class CommandMap extends Command {

    public CommandMap() {
        super("map", "Displays the map.");
    }

    @Override
    public void execute(Game game, String[] args) {
        WorldMap worldMap = game.getWorldMap(); 
        Player player = game.getPlayer();       

        Zone[][] zones = worldMap.getZones();

        IPrintable[][] printableMap = new IPrintable[zones.length][zones[0].length]; // print map 
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[i].length; j++) {
                printableMap[i][j] = zones[i][j];
            }
        }

        int playerRow = player.getCurrentZone().getX();
        int playerCol = player.getCurrentZone().getY();

        
        System.out.println(Array2Dprinter.print2DArray(printableMap, playerRow, playerCol)); // affiche carte avec position joueur
    }
}
