package commands;
import main.Game;
import objet.Cle;
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
    }
}