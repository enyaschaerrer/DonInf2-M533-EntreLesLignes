package commands;

import main.Game;



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
        Player player = game.getPlayer(); // récupère le joueur
        Zone currentZone = player.getCurrentZone(); // zone où il se trouve

        Objet objet = currentZone.getObjetByName(objectName); // cherche l'objet dans la zone

        if (objet != null) {
            player.getInventaire().addObjet(objet); // ajoute à l'inventaire
            currentZone.removeObjet(objet); // enlève de la zone
            System.out.println("You picked up: " + objectName);
        } else {
            System.out.println("There is no object here with that name.");
        }
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