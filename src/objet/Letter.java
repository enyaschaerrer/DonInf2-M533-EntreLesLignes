package objet;

import enigme.Enigme;
import zone.Zone;

public class Letter extends Objet{

    private Enigme enigme;

    public Letter(Enigme enigme, Zone zone) {
        super(zone);
        this.enigme = enigme;
    }

    @Override
    public String inspect(Objet objet) {

        if (objet instanceof Letter) {
            return "A letter. ";
        }
        return null;
    }

    public void setEnigme(Enigme enigme) {
        this.enigme = enigme;
    }
}
