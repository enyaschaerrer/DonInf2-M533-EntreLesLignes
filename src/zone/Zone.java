package zone;


public class Zone{
    private String name;
    private String description;
    private String state;


    public Zone(String name, String description, String state){
        this.nom = nom;
        this.description = description;
        this.state = state;
    }

    public String getName(){
        return name;
    }

     public String getDescription(){
        return description;
    }

     public String getState(){
        return state;
    }

    public void unlock(){
        this.state = "unlocked";
    }

    public void lock(){
        this.state = "locked";
    }


}
