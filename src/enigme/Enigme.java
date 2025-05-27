package enigme;

import objet.Key;
import zone.Zone;

public class Enigme{

    private Key cle;
    private Zone zone;
    private String solution;

    public Enigme(Zone zone, String solution, Key cle){
        this.zone = zone;
        this.solution = solution;
        this.cle = cle;
    }

    public Key dropCle(String solution){
        if (solution.equals(this.solution)) {
            return this.cle;
        }
        return null;
    }

    protected Key getCle(){
        return this.cle;
    }
}