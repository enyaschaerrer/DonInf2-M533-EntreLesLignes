package player;

import inventaire.Inventaire;

import java.util.ArrayList;
import java.util.List;
import zone.Zone;

public class Player {

    private Inventaire inventaire;
    private Zone currentZone;
    private List<Zone> visitedZones;

    public Player(Inventaire inventaire) {
        this.inventaire = inventaire;
        this.visitedZones = new ArrayList<>();
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
        if (!hasVisitedZone(zone.getName())) {
            addVisitedZone(zone);
        }

    }

    public boolean hasVisitedZone(String zoneName) {
        for (Zone z : visitedZones) {
            if (z.getName().equalsIgnoreCase(zoneName)) {
                return true;
            }
        }
        return false;
    }

    public List<Zone> getVisitedZones() {
        return visitedZones;
    }

    public void addVisitedZone(Zone zone) {
        this.visitedZones.add(zone);
    }

}
