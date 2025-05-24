package player;

import inventaire.Inventaire;
import zone.Zone;

public class Player {

    private Inventaire inventaire;
    private Zone currentZone;
    //private int row;
    //private int column;

    public Player(Inventaire inventaire) {
        this.inventaire = inventaire;
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
    }

}
