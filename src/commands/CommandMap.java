package commands;

import joueur.Player;
import zone.Zone;
import worldmap.WorldMap;
import utils.Array2Dprinter;
import utils.IPrintable;

public class CommandMap extends Command {
    private WorldMap worldMap;


    public CommandMap() {
        super("map", "It display the map.");
        this.worldMap = worldMap;
    }

    @Override
    protected String doExecute(Player player, Zone zone) {
        // Récupère la carte du monde
        Zone[][] zones = worldMap.getZones();  // méthode à ajouter si elle n'existe pas

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

        return Array2Dprinter.print2DArray(printableMap, playerRow, playerCol);
    }
}