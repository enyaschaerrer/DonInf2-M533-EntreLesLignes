package objet;

public class Cle extends Objet {

    public Cle(Zone zone){
        super(zone);
    }

    public void unlockZone(Zone zone){
        zone.unlock();
        System.out.println("La zone " + zone.getName() + " est déverouillée. ");
    }

    @Override
    public String inspect(Objet objet){
        return "L'objet est une clé. ";
    }
}
