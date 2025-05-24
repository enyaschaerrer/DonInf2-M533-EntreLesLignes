package objet;

import enigme.Enigme;
import zone.Zone;

public class Lettre extends Objet{

    private Enigme enigme;

    public Lettre(Enigme enigme, Zone zone) {
        super(zone);
        this.enigme = enigme;
    }

    @Override
    public String inspect(Objet objet) {

        if (objet instanceof Lettre) {
            return "The object is a letter. ";
        }
        return null;
    }

    public void setEnigme(Enigme enigme) {
        this.enigme = enigme;
    }
}
