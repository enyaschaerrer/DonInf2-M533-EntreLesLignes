package zone;

import utils.IPrintable;

public class Zone implements IPrintable {

    private String name;
    private String description;
    private boolean locked;

    // Coordonnées optionnelles, utiles pour la carte
    private int x;
    private int y;

    public Zone(String name, String description, boolean locked) {
        this.name = name;
        this.description = description;
        this.locked = locked;
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
        // première lettre nom zone, en majuscule
        return this.getName();
    }

    @Override
    public boolean isGrayedOut() {
        // si zone verrouillée = grise
        return locked;
    }

}
