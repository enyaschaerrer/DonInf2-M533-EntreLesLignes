package enigme;

import objet.Key;
import zone.Zone;

public class Enigme {

    private Key cle;
    private Zone zone;
    private String solution;
    private String question;

    // je me demande juste comment ca marche pour enigme
    // dans le sens genre c'est nous qui devons créer une engime et dire quelle est
    // la bonne reposne et totu????
    public Enigme(String question, Zone zone, String solution, Key cle) {
        this.question = question;
        this.zone = zone;
        this.solution = solution;
        this.cle = cle;
    }

    public String getQuestion() {
        return this.question;
    }

    public Key dropCle(String solution) {
        if (solution.equals(this.solution)) {
            return this.cle;
        }
        return null;
    }

    protected Key getCle() {
        return this.cle;
    }
}