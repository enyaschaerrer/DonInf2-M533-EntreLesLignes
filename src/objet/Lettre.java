package objet;

import enigme.Enigme;
import zone.Zone;

<<<<<<< Updated upstream:src/objet/Lettre.java
public class Lettre extends Objet{
=======
public class Letter extends Objet{
>>>>>>> Stashed changes:src/objet/Letter.java

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
