package player;

import inventaire.Inventaire;
import java.util.HashSet;
import java.util.Set;
import zone.Zone;

public class Player {

    private static Inventaire inventaire;
    private Zone currentZone;
    private Set<String> visitedZones;
    
    public Player(Inventaire inventaire) {
        this.inventaire = inventaire;
        this.visitedZones = new HashSet<>();
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    public Zone getCurrentZone() {
        return currentZone;
    }

    public void setCurrentZone(Zone zone) {
        this.currentZone = zone;
        if (zone != null) {
           //visitedZones.add(zone.getObjetByName(Name));
        }

    }

    public static String getItems(String itemName) {
        return itemName;
    }


}
