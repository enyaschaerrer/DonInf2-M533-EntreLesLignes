package inventaire;

import java.util.ArrayList;
import java.util.List;
import objet.Cle;
import objet.Lettre;
import objet.Objet;

public class Inventaire {

    private List<Objet> objets = new ArrayList<>();

    public Inventaire(List<Objet> objets) {
        this.objets = objets;
    }

    public void addObjet(Objet objet) {
        objets.add(objet);
    }

    public void removeObjet(Objet objet) {
        objets.remove(objet);
    }

    public void displayInventaire(){
        
        for (int i = 0; i < this.objets.size(); i++) {

            if (objets.get(i) instanceof Cle) {
                System.out.println("Une clé pour la zone " + objets.get(i).getZone());
            } else if(objets.get(i) instanceof Lettre) {
                System.out.println("Une lettre pour la zone " + objets.get(i).getZone());
            }
        }
    }

    public Cle getCle(String zone) {
        for (Objet objet : this.objets) {
            if (objet instanceof Cle && objet.getZone().equals(zone)) {
                return (Cle) objet;
            }
        }
        return null;
    }
}