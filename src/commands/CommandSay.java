package commands;

import main.Game;
import objet.Key;
import objet.Letter;
import player.Player;

public class CommandSay extends Command {
    public CommandSay() {
        super("say", "say <answer>: Answer the current riddle.");
    }

    @Override
    public void execute(Game game, String[] args) {

        Player player = game.getPlayer();
        Letter l = (Letter) player.getInventaire().getLastObjectByName("letter");
        String playerAnswer = args[0];

        if (args.length == 0) {
            System.out.println("Please type an answer to this riddle.");
            return;
        }

        if (l.getEnigme() == null) {
            System.out.println("There is no riddle to answer.");
            return;
        }

        if (l.getEnigme().getSolution().equals(playerAnswer)) {
            Key cleGagnee = l.getEnigme().dropCle(playerAnswer);
            player.getInventaire().addObjet(cleGagnee);
            game.setCurrentEnigme(null); // on efface l’énigme active

            System.out.println("Correct! You received a key for the zone: " + cleGagnee.getZoneItUnlocks().getName()
                    + ". You can now use the key and then move to this zone.");

        } else {
            // si la réponse elle est fausse
            System.out.println("Wrong answer. Try again with: say <your answer>");

        }
    }
}
