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
        
        Game game = new Game();
        game.run();

        System.out.println(StringStyling.StyleString("Starting...", Style.ITALIC, Color.BLACK));
        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));
    }
}
