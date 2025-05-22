package joueur;
import inventaire.Inventaire;

public class Player{
    
    private Inventaire inventaire;
    private int row;
    private int column; //j'ai rajouté ca pour pouvoir mettre la position du joueur sur la map

    public Player(Inventaire inventaire, int row, int column){
        this.inventaire = inventaire;
        this.row = row;
        this.column = column;

    }

    public Inventaire getInventaire(){
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire){
        this.inventaire = inventaire;
    }

    public int getColumn (){
        return this.column;
    }

    public int getRow(){
        return this.row;
    }

    public void setPosition(int row, int column){ // du coup un set pour la nouvelle pos du joueur
        this.column = column;
        this.row = row;
    }


}