package objet;

public class Cle {
    public void unlockZone(Zone zone){
        zone.unlock();
        System.out.println("La zone " + zone.getName() + " est déverouillée. ");
    }
}
