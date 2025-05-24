package objet;

import zone.Zone;

public class Cle extends Objet {

    public Cle(Zone zone) {
        super(zone);
    }

    public void unlockZone(Cle cle, Zone zone) {

        // si zone (objet) correspond a clé en args ????

        zone.unlock();
        System.out.println("The zone " + zone.getName() + " is unlocked. ");
    }

    @Override
    public String inspect(Objet objet) {

        if (objet instanceof Cle) {
            return "The object is a key. ";
        }
        return null;
    }
}
