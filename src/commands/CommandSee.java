package commands;

import inventaire.Inventaire;
import main.Game;

public class CommandSee extends Command {

    public CommandSee() {
        super("see", "Displays the player's inventory.");
        this.inventaire = i;
    }

    private Inventaire inventaire;

    @Override
    public void execute(Game game, String[] args) {
        this.inventaire.displayInventaire();
    }

}
