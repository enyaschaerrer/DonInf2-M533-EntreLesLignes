package inventaire;

import java.util.ArrayList;
import java.util.List;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import objet.Cle;
import objet.Lettre;
=======
import objet.Key;
>>>>>>> Stashed changes
=======
import objet.Key;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
<<<<<<< Updated upstream
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
=======
    /*public void displayInventaire() {

=======
    /*public void displayInventaire() {

>>>>>>> Stashed changes
        for (int i = 0; i < this.objets.size(); i++) {

            if (objets.get(i) instanceof Key) {
                System.out.println("There's the key for the area " + objets.get(i).getZone());
             /*} else if (objets.get(i) instanceof Letter) {
                System.out.println("A letter for the area " + objets.get(i).getZone());
            }
        }
    }*/

    public List<Objet>getObjets(){
        return objets;
    }


    public Key getCle(String zone) {
        for (Objet objet : this.objets) {
            if (objet instanceof Key && objet.getZone().equals(zone)) {
                return (Key) objet;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
            }
        }
        return null;
    }
}