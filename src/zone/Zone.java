package zone;

import java.util.ArrayList;
import java.util.List;
import objet.Objet;
import utils.IPrintable;

public class Zone implements IPrintable {

    List<Objet> objets = new ArrayList<>();

    private String name;
    private String description;
    private boolean locked;

    private int x;
    private int y;

    public Zone(String name, String description, boolean locked, int x, int y) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {
        this.locked = false;
    }

    public void lock() {
        this.locked = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String getPrintableString() {
        return this.getName();
    }

    @Override
    public boolean isGrayedOut() {
        // si zone verrouillée = grise
        return locked;
    }


    // code pour la liste d'objets qui sont dans les zones ->

    public void addObjet(Objet objet) {
        objets.add(objet);
    }

    public void removeObjet(Objet objet) {
        objets.remove(objet);
    }

    public Objet getObjetByName(String name) {
        for (Objet o : objets) {
            if (o.getClass().getSimpleName().equalsIgnoreCase(name)) { 
                return o;
            }
        }
        return null;
    }


    public List<Objet> getObjets() {
        return objets;
    }

}
