package commands;

import inventaire.Inventaire;
import main.Game;

public class CommandSee extends Command {

    public CommandSee(Inventaire i) {
        super("see", "Displays the player's inventory.");
        this.inventaire = i;
    }

    private Inventaire inventaire;

    public void execute(Game game, String[] args) {
        this.inventaire.displayInventaire();
    }

}
