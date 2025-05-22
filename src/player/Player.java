package player;

import inventaire.Inventaire;
import zone.Zone;

public class Player {

    private Inventaire inventaire;
    private Zone zone;
    private int row;
    private int column;

    public Player(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public Zone getPlayerZone(){
        return this.zone;
    }

    // jsp encore cmt faire
    public void setPlayerZone(Zone zone){
    }

}