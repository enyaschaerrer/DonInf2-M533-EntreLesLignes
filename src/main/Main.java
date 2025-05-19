package main;

import examples.ConsoleStylingExample;
import examples.StringManipulation;
import examples.UserInputExample;
import utils.Color;
import utils.StringStyling;
import utils.Style;
import zone.Zone;

public class Main {

    public static void main(String[] args) {
        // you can safely remove those examples lines
        /*
         * StringManipulation.Example();
         * ConsoleStylingExample.Example();
         * UserInputExample.Example();
         */
        Game game = new Game();

        Zone zone1 = new Zone("désert", "étendue de sable", "locked");
        Zone zone2 = new Zone("forêt", "étendue de sapins", "locked");
        Zone zone3 = new Zone("lac", "étendue d'eau profonde", "locked");
        Zone zone4 = new Zone("étang", "étendue d'eau stagnante", "locked");

        System.out.println(StringStyling.StyleString("Starting...", Style.ITALIC, Color.BLACK));
        game.run();
        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));
    }
}
