package worldmap;

import zone.Zone;

public class WorldMap {

    private static Zone[][] zones;

    public WorldMap(int nbRows, int nbColumns) {
        zones = new Zone[nbRows][nbColumns];
    }

    public void addZone(Zone zone) {
        if (zone.getX() >= 0 && zone.getX() < zones.length && zone.getY() >= 0 && zone.getY() < zones[0].length) {
            zones[zone.getX()][zone.getY()] = zone;
        }
    }

    public static Zone getZone(int row, int column) {
        if (row >= 0 && row < zones.length && column >= 0 && column < zones[0].length) {
            return zones[row][column];
        }
        return null;
    }

    public static Zone[][] getZones() {
        return zones;
    }

    // retourne la zone voisine dans une direction donnée
    public static Zone getAdjacentZone(Zone currentZone, String direction) {
        int currentRow = currentZone.getX();
        int currentCol = currentZone.getY();

        switch (direction.toLowerCase()) {
            case "north":
                return getZone(currentRow - 1, currentCol);
            case "south":
                return getZone(currentRow + 1, currentCol);
            case "east":
                return getZone(currentRow, currentCol + 1);
            case "west":
                return getZone(currentRow, currentCol - 1);
            default:
                return null;
        }
    }

    public static Zone getStartingZone() {
        return getZone(0, 0); // Position de départ
    }
}
