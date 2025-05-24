package main;

import java.util.*;

import commands.Command;
import commands.CommandHelp;
import commands.CommandInspect;
import commands.CommandLook;
import commands.CommandMap;
import commands.CommandMove;
import commands.CommandRegistry;
import inventaire.Inventaire;
import objet.Objet;
import player.Player;
import worldmap.WorldMap;
import zone.Zone;

public class Game {

    private WorldMap worldMap = new WorldMap(4, 4);
    private Player player;
    private CommandRegistry registry;
    private List<Objet> allObjects = new ArrayList<>();

    public Game() {
        System.out.println("Initializing game...");

        // création de zones
        Zone desert = new Zone("désert", "étendue de sable", true);
        Zone foret = new Zone("forêt", "étendue de sapins", true);
        Zone lac = new Zone("lac", "étendue d'eau profonde", true);
        Zone etang = new Zone("étang", "étendue d'eau stagnante", true);
        Zone montagne = new Zone("montagne", "pic rocheux", true);

        // ajout des zones a la map
        worldMap.addZone(desert, 1, 1);
        worldMap.addZone(foret, 1, 2);
        worldMap.addZone(lac, 1, 3);
        worldMap.addZone(etang, 2, 1);
        worldMap.addZone(montagne, 2, 2);

        List<Objet> objPlayer = null;
        Inventaire inventaire = new Inventaire(objPlayer);

        player = new Player(inventaire);
        player.setCurrentZone(desert); // zone 1

        // pas sure
        registry = new CommandRegistry();
        CommandHelp help = new CommandHelp(registry);
        registry.registerCommand(help);
        

    }

    public void run() {
        System.out.println("Running game...");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split("\\s+");
            String commandName = parts[0];
            String[] args = Arrays.copyOfRange(parts, 1, parts.length);

            Command command = registry.get(commandName);
            if (command != null) {
                command.execute(this, args);
            } else {
                System.out.println("Command unknown. Say 'help' to get the list of all the commands available.");
            }
        }
    }


    }

    public Player getPlayer() {
        return this.player;
    }

    public List<Objet> getObjects() {
        return this.allObjects;
    }

    public void addObject(Objet obj) {
        this.allObjects.add(obj);
    }

    public WorldMap getWorldMap() {
        return this.worldMap;
    }

}