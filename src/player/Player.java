package player;

import inventaire.Inventaire;
import java.util.HashSet;
import java.util.Set;
import zone.Zone;

public class Player {

    private Inventaire inventaire;
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

    // pouvoir ajouter la zone actuel dans laquelle le joueur est
    public void setCurrentZone(Zone zone) {
        this.currentZone = zone;
        if (zone != null) {
           //visitedZones.add(zone); 
        }

    }

    public static String getItems(String itemName) {
        return itemName;
    }


}
