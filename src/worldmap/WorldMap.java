package worldmap;

import player.Player;
import zone.Zone;

public class WorldMap {
    private Zone[][] zones;

    public WorldMap(int nbRws, int nbColumns) {
        zones = new Zone[nbRws][nbColumns];
    }

    public void addZone(Zone zone, int row, int column) {
        if (row >= 0 && row < zones.length && column >= 0 && column < zones.length) {
            zones[row][column] = zone;
        }
    }

    public Zone getZone(int row, int column) {
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[i].length; j++) {
                if (zones[i][j] == zones[row][column]) {
                    return zones[i][j];
                }
            }
        }
        return null;
    }

    // a revoir
    public Zone getPlayerZone(Player player) {
        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[i].length; j++) {
                Zone zone = zones[i][j]; // ???
                if (zone != null && zone.getPlayer() == player) {
                    return zone;

                }
            }
        }
        return null;
    }


    // a revoir
    public void setPlayerZone(Player player, int row, int column) {

        for (int i = 0; i < zones.length; i++) {
            for (int j = 0; j < zones[i].length; j++) {
                Zone zone = zones[i][j];
                if (zone != null && zone.getPlayer() == player) {
                    zone.setPlayer(null);
                }
            }
        }

    }

    public Zone[][] getZones() {
        return this.zones;
    }

}
