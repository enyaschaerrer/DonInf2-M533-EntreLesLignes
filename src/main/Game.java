package main;

import commands.Command;
import commands.CommandHelp;
import commands.CommandInspect;
import commands.CommandLook;
import commands.CommandMap;
import commands.CommandMove;
import commands.CommandRegistry;
import commands.CommandSee;
import commands.CommandTake;
import commands.CommandUse;
import enigme.Enigme;
import inventaire.Inventaire;
import java.util.*;
import objet.Key;
import objet.Objet;
import player.Player;
import worldmap.WorldMap;
import zone.Zone;

public class Game {

    private WorldMap worldMap = new WorldMap(4, 4);
    private Player player;
    private CommandRegistry registry;
    private List<Objet> allObjects = new ArrayList<>();
    private Enigme currentEnigme;

    public Game() {
        System.out.println("Initializing game...");

        // création de zones
        Zone desert = new Zone("desert", "expanse of sand", true, 0, 0);
        Zone forest = new Zone("forest", "expanse of fir trees", true, 0, 1);
        Zone lake = new Zone("lake", "deep water body", true, 0, 2);
        Zone pond = new Zone("pond", "body of stagnant water", true, 0, 3);
        Zone mountains = new Zone("mountains", "rocky peaks", true, 1, 0);

        // ajout des zones a la map
        worldMap.addZone(desert);
        worldMap.addZone(forest);
        worldMap.addZone(lake);
        worldMap.addZone(pond);
        worldMap.addZone(mountains);

        desert.addObjet(new Key(desert, forest));
        forest.addObjet(new Key(forest, pond));

        Inventaire inventaire = new Inventaire();

        player = new Player(inventaire);

        desert.unlock(); // car joueur commence là
        player.setCurrentZone(desert);

        // ajoute les commandes
        registry = new CommandRegistry();
        CommandHelp cmdHelp = new CommandHelp(registry);
        registry.registerCommand(cmdHelp);

        CommandMap cmdMap = new CommandMap();
        registry.registerCommand(cmdMap);

        CommandMove cmdMove = new CommandMove();
        registry.registerCommand(cmdMove);

        CommandLook cmdLook = new CommandLook(this.player.getCurrentZone());
        registry.registerCommand(cmdLook);

        CommandTake cmdTake = new CommandTake();
        registry.registerCommand(cmdTake);

        CommandInspect cmdInspect = new CommandInspect();
        registry.registerCommand(cmdInspect);

        CommandUse cmdUse = new CommandUse();
        registry.registerCommand(cmdUse);

        CommandSee cmdSee = new CommandSee();
        registry.registerCommand(cmdSee);

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
            String commandName = parts[0].toLowerCase();
            String[] args = Arrays.copyOfRange(parts, 1, parts.length);

            Command command = registry.getCommand(commandName);

            // a revoir
            if (command != null) {

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

    public void setCurrentEnigme(Enigme enigme) {
        this.currentEnigme = enigme;
    }

    public Enigme getCurrentEnigme() {
        return this.currentEnigme;
    }

}