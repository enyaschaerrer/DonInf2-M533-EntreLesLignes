package inventaire;

import java.util.ArrayList;
import java.util.List;
import objet.Key;
import objet.Objet;

public class Inventaire {

    private List<Objet> objets = new ArrayList<>();

    public Inventaire() {
    }

    public void addObjet(Objet objet) {
        objets.add(objet);
    }

    public void removeObjet(Objet objet) {
        objets.remove(objet);
    }

    /*public void displayInventaire() {

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
            }
        }
        return null;
    }
}