package objet;

import zone.Zone;

public class Key extends Objet {

    private Zone zoneItUnlocks;

    public Key(Zone zone, Zone zoneItUnlocks) {
        super(zone);
        this.zoneItUnlocks = zoneItUnlocks;
    }

    public void unlockZone(Zone zone) {
        zone.unlock();
        System.out.println("The zone " + zone.getName() + " is unlocked. ");
    }

    @Override
    public String inspect(Objet objet) {

        if (objet instanceof Key) {
            return "A key.";
        }
        return null;
    }

    public Zone getZoneItUnlocks() {
        return this.zoneItUnlocks;
    }

}
