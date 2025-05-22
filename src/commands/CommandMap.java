package commands;

import zone.Zone;
import worldmap.WorldMap;
import player.Player;
import utils.Array2Dprinter;
import utils.IPrintable;

public class CommandMap extends Command {

    private WorldMap worldMap;


    public CommandMap() {
        super("map", "It displays the map.");
        //this.worldMap = worldMap;
    }

    @Override
    public void execute(Player player, Zone zone) {

        // Récupère la carte du jeu
        Zone[][] zones = worldMap.getZones();

        // transformer la carte zone en genre un version qu on puisse l'afficher avec le joueur dessus
        IPrintable[][] printableMap = new IPrintable[zones.length][zones[0].length];
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[i].length; j++) {
                printableMap[i][j] = zones[i][j];
            }
        }

        // du coup pour afficher la carte avec la position du joueur
        int playerRow = player.getRow();
        int playerCol = player.getColumn();

        System.out.println(Array2Dprinter.print2DArray(printableMap, playerRow, playerCol));
    }
}