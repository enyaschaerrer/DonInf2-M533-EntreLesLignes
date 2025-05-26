package objet;

import zone.Zone;

public abstract class Objet {

    private Zone zone;

    public Objet(Zone zone) {
        this.zone = zone;
    }

    public abstract String inspect(Objet objet); // sous-classes obligées d'implémenter

    public Zone getZone() {
        return this.zone;
    }

}
