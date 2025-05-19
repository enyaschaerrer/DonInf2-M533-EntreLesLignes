package joueur;
import inventaire.Inventaire;

public class Player{
    
    private Inventaire inventaire;

    public Player(Inventaire inventaire){
        this.inventaire = inventaire;

    }

    public Inventaire getInventaire(){
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire){
        this.inventaire = inventaire;
    }


}