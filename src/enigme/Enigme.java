package enigme;

import objet.Cle;
import zone.Zone;

public class Enigme{

    private Cle cle;
    private Zone zone;
    private String solution;

    public Enigme(Zone zone, String solution, Cle cle){
        this.zone = zone;
        this.solution = solution;
        this.cle = cle;
    }

    public Cle dropCle(String solution){
        if (solution.equals(this.solution)) {
            return this.cle;
        }
        return null;
    }

    protected Cle getCle(){
        return this.cle;
    }
}