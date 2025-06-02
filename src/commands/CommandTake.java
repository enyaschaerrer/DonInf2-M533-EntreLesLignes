package commands;
import main.Game;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import objet.Cle;
=======
=======
>>>>>>> Stashed changes
import objet.Objet;
>>>>>>> Stashed changes
import player.Player;
import zone.Zone;
import.inventaire.Inventaire;

public class CommandTake extends Command {
    private String objectName;

    public CommandTake(String objectName) {
        super("take", "Pick up an object.");
        this.objectName = objectName;
    }

    @Override
    public void execute(Game game, String[] args) {
        // ca doit mettre dans l'inventaire
    }

    private void ajouterCle(Game game, String zone) {
        try {
            
            Cle nouvelleCle = new Cle(zone);
            
            game.getObjects().addLast(nouvelleCle);
            
            System.out.println("✓ Clé pour la zone '" + zone + "' ajoutée à votre inventaire!");
            
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de la clé: " + e.getMessage());
        }
<<<<<<< Updated upstream
=======
        Player player = game.getPlayer(); // récupère le joueur
        Zone currentZone = player.getCurrentZone(); // zone où il se trouve
        String objectName = args[0];

        Objet object = currentZone.getObjetByName(objectName); // cherche l'objet dans la zone

        if (object != null) {
            player.getInventaire().addObjet(object); // ajoute à l'inventaire
            currentZone.removeObjet(object); // enlève de la zone
            System.out.println("You picked up a " + objectName + " for the area : " + object.getZone().getName());
        } else {
            System.out.println("There is no object here with this name.");
        }
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    }
}