package enigme;

import objet.Key;
import zone.Zone;

public class Enigme {

    private Key cle;
    private Zone zone;
    private String solution;
    private String question;

    public Enigme(String question, Zone zone, String solution, Key cle) {
        this.question = question;
        this.zone = zone;
        this.solution = solution;
        this.cle = cle;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getSolution(){
        return this.solution;
    }

    public Key dropCle(String solution) {
        if (solution.equals(this.solution)) {
            return this.cle;
        }
        return null;
    }

    public Key getCle() {
        return this.cle;
    }
}