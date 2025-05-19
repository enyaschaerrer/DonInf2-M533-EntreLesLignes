package objet;

import zone.Zone;

public class Cle extends Objet {

    public Cle(Zone zone) {
        super(zone);
    }

    public void unlockZone(Cle cle, Zone zone) {

        // si zone (objet) correspond a clé en args ????

        zone.unlock();
        System.out.println("La zone " + zone.getName() + " est déverouillée. ");
    }

    @Override
    public String inspect(Objet objet) {

        if (objet instanceof Cle) {
            return "L'objet est une clé. ";
        }
        return null;
    }
}
