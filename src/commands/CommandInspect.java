package commands;

import main.Game;
import objet.Cle;
import objet.Lettre;
import objet.Objet;
import player.Player;
import zone.Zone;

public class CommandInspect extends Command {

    private Objet object;

    public CommandInspect(Objet object) {
        super("inspect", "Command to inspect an object.");
        this.object = object;
    }

    @Override
    public void execute(Game game, String[] args) {
        if (this.object instanceof Cle) {
            System.out.println("L'objet est une clé pour la zone " + this.object.getZone());
        } else if (this.object instanceof Lettre) {
            System.out.println("L'objet est une lettre pour la zone " + this.object.getZone());
        }
    }
}
