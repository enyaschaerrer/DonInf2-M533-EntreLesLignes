package main;

import commands.Command;
import commands.CommandHelp;
import commands.CommandMap;
import commands.CommandMove;
import commands.CommandRegistry;
import inventaire.Inventaire;
import java.util.*;
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
        Zone desert = new Zone("desert", "expanse of sand", true);
        Zone forest = new Zone("forest", "expanse of fir trees", true);
        Zone lake = new Zone("lake", "deep water body", true);
        Zone pond = new Zone("pond", "body of stagnant water", true);
        Zone mountains = new Zone("mountains", "rocky peaks", true);

        // ajout des zones a la map
        worldMap.addZone(desert, 0, 0);
        worldMap.addZone(forest, 0, 1);
        worldMap.addZone(lake, 0, 2);
        worldMap.addZone(pond, 0, 3);
        worldMap.addZone(mountains, 1, 0);

        List<Objet> objPlayer = null;
        Inventaire inventaire = new Inventaire(objPlayer);

        player = new Player(inventaire);

        desert.unlock(); // car joueur commence là
        player.setCurrentZone(pond); // zone 1 - CA MARCHE PAS

        // ajoute les commandes
        registry = new CommandRegistry();
        CommandHelp cmdHelp = new CommandHelp(registry);
        registry.registerCommand(cmdHelp);

        CommandMap cmdMap = new CommandMap();
        registry.registerCommand(cmdMap);

        CommandMove cmdMove = new CommandMove();
        registry.registerCommand(cmdMove);

    }

    public void run() {
        System.out.println("Running game...");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");

            // .trim() enlève les espaces en début et fin de la saisie
            String input = scanner.nextLine().trim();
            if (input.isEmpty())
                continue;

            // sépare saisie en plusieurs mots
            String[] parts = input.split("\\s+");

            // nom de la commande (move/ map...)
            String commandName = parts[0];

            // ?
            String[] args = Arrays.copyOfRange(parts, 1, parts.length);

            Command command = registry.getCommand(commandName); // regarder getCommand

            // a revoir
            if (command != null) {

                if (command instanceof CommandMove) {
                    
                }


                command.execute(this, args);
            } else {
                System.out.println("Command unknown. Say 'help' to get the list of all the commands available.");
            }
        }
    }

    // méthode afficher carte ?


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