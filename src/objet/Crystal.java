package objet;

import zone.Zone;

public class Crystal extends Objet {

    public Crystal(Zone zone) {
        super(zone);
    }

    @Override
    public String inspect(Objet objet) {
        return "A crystal that helps you teleport to an already visited zone.";
    }

    @Override
    public String toString() {
        return "crystal";
    }
}
