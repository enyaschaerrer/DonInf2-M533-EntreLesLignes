package commands;


import main.Game;

public class CommandTeleport extends Command {

    public CommandTeleport(String verb, String description) {
        super(verb, description);
        
        }

      @Override
    public void execute(Game game, String[] args) {
        /*if (!Player.getItems("Teleport Crystal")) {
            System.out.println("Vous avez besoin du Teleport Crystal pour utiliser cette commande.");
            return;
        }*/

        if (args.length < 2) {
            System.out.println("Utilisation : teleport nom-du-lieu");
            return;
        }
        /*
        String destination = allZones.get(getName);

        if (!Player.hasVisited(destination.getName())) {
            System.out.println("Vous ne pouvez vous téléporter qu'à des endroits déjà visités.");
            return;
        }

        // Logique de téléportation :
        Player.setCurrentZone(destination){
        System.out.println("Téléportation vers " + currentZone + " effectuée !");
    
        }*/
    }
}
