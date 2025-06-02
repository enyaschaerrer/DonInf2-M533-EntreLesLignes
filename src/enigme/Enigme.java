package enigme;

import objet.Cle;
import zone.Zone;

public class Enigme{

    private Cle cle;
    private Zone zone;
    private String solution;

<<<<<<< Updated upstream
    public Enigme(Zone zone, String solution, Cle cle){
=======
    public Enigme(Zone zone, String solution, Key cle){
>>>>>>> Stashed changes
        this.zone = zone;
        this.solution = solution;
        this.cle = cle;
    }

<<<<<<< Updated upstream
    public Cle dropCle(String solution){
=======
    public Key dropCle(String solution){
>>>>>>> Stashed changes
        if (solution.equals(this.solution)) {
            return this.cle;
        }
        return null;
    }

<<<<<<< Updated upstream
    protected Cle getCle(){
=======
    protected Key getCle(){
>>>>>>> Stashed changes
        return this.cle;
    }
}