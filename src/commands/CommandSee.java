package commands;

import inventaire.Inventaire;
import main.Game;
import objet.Objet;
import player.Player;

public class CommandSee extends Command {

    Inventaire i = this.inventaire;

    public CommandSee() {
        super("see", "Displays the player's inventory.");
        this.inventaire = i;
    }

    private Inventaire inventaire;

    @Override
    public void execute(Game game, String[] args) {
        //this.inventaire.displayInventaire();

        Player player = game.getPlayer();
        Inventaire inventaire = player.getInventaire();

        if (inventaire.getObjets().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You have:");
            for (Objet objet : inventaire.getObjets()) {
                System.out.println("- " + objet.inspect(objet)); // Affiche la description de chaque objet
            }
        }
    }
    

}
