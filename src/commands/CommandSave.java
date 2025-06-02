package commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import main.Game;

public class CommandSave extends Command {

    public CommandSave() {
        super("save", "Save all the commands said.");
    }

    @Override
    public void execute(Game game, String[] args) {

        List<String> history = game.getCommandHistory();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cmdSaid.txt"))) {
            for (String c : history) {
                writer.write(c);
                writer.newLine();
            }
            System.out.println("All commands saved! ");
        } catch (IOException e) {
            System.out.println("Error saving commands: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void readPastCmd(Game game) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("cmdSaid.txt"));

            for (String l : lines) {
                String[] parts = l.trim().split("\\s+");
                if (parts.length == 0)
                    continue;

                String commandName = parts[0].toLowerCase();
                String[] args = Arrays.copyOfRange(parts, 1, parts.length);
                Command command = game.getRegistry().getCommand(commandName);

                if (command != null) {
                    System.out.println("> " + l);
                    command.execute(game, args);
                    game.getCommandHistory().add(l);
                }
            }
            System.out.println("Previous commands loaded from save.");

        } catch (IOException e) {
            System.out.println("Error reading commands: " + e.getMessage());
        }
    }

}
