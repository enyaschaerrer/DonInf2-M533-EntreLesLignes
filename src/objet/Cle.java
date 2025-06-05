package objet;

import zone.Zone;

public class Cle extends Objet {

    public Cle(Zone zone) {
        super(zone);
    }

    public void unlockZone(Cle cle, Zone zone) {

 //elle doit être dans l'inventaire


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
