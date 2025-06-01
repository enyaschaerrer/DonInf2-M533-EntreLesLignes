package inventaire;

import java.util.ArrayList;
import java.util.List;
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


    public List<Objet> getObjets() {
        return objets;
    }


    public Objet getLastObjectByName(String objectName) {
        for (int i = objets.size() - 1; i >= 0; i--) {
            Objet o = objets.get(i);
            if (o.getClass().getSimpleName().equalsIgnoreCase(objectName)) {
                return o;
            }
        }
        return null;
    }

}
