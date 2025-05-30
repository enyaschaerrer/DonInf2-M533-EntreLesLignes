package commands;

import enigme.Enigme;
import main.Game;
import objet.Key;
import player.Player;

public class CommandSay extends Command {
    public CommandSay() {
        super("say", "say <answer>: Answer the current riddle.");
    }

    @Override
    public void execute(Game game, String[] args) {
        if (args.length == 0) {
            System.out.println("Please tipe an answer to this ridle.");
            return;
        }

        Enigme enigme = game.getCurrentEnigme();

        if (enigme == null) {
            System.out.println("There is no riddle to answer.");
            return;
        }

        // comme la reponse est dans un args [], pour pas separer la reponse mot par mot
        // => ca va coller la reponse comme si cetait un truc ensemble
        String playerAnswer = String.join(" ", args);

        Key cle = enigme.dropCle(playerAnswer); // pour verifier la reponse du joueur

        if (cle != null) {
            // si le joeuur ecrit la bonne reponse
            Player player = game.getPlayer();
            player.getInventaire().addObjet(cle);
            game.setCurrentEnigme(null); // on efface l’énigme active
            System.out.println("Correct! You received a key for the zone: " + cle.getZoneItUnlocks().getName());
        } else {
            // au cas ou si la reponse elle est fausse
            System.out.println(" Mrunhhhnhn wrong answer. Try again with: say <your answer>");
        }
    }
}
