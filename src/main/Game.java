package main;

import commands.Command;
import commands.CommandHelp;
import commands.CommandInspect;
import commands.CommandLook;
import commands.CommandMap;
import commands.CommandMove;
import commands.CommandRegistry;
import commands.CommandSay;
import commands.CommandSee;
import commands.CommandTake;
import commands.CommandTeleport;
import commands.CommandUse;
import enigme.Enigme;
import inventaire.Inventaire;
import java.util.*;
import objet.Key;
import objet.Letter;
import objet.Objet;
import player.Player;
import worldmap.WorldMap;
import zone.Zone;

public class Game {

    private WorldMap worldMap = new WorldMap(2, 4);
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
        Zone startZone = new Zone("startZone", "starting zone", false, 1, 1);
        Zone arrival = new Zone("arrival", "success", true, 1, 3);

        // ajout des zones a la map
        worldMap.addZone(desert);
        worldMap.addZone(forest);
        worldMap.addZone(lake);
        worldMap.addZone(pond);
        worldMap.addZone(mountains);
        worldMap.addZone(startZone);
        worldMap.addZone(arrival);

        Inventaire inventaire = new Inventaire();

        player = new Player(inventaire);

        startZone.unlock(); // car joueur commence là
        player.setCurrentZone(startZone);


        // les objets

        startZone.addObjet(
                new Letter(new Enigme("What's the altitude of the Mount Everest? 1. 8001m 2. 8849m 3. 9023m",
                        startZone, "2", new Key(startZone, mountains)), startZone));

        mountains.addObjet(
                new Letter(new Enigme("What is the biggest desert in the world? 1. Sahara 2. Kalahari 3. Antartica",
                        mountains, "3", new Key(mountains, desert)), mountains));

        desert.addObjet(
                new Letter(new Enigme(
                        "Which layer of the forest gets the most sunlight? 1. canopy 2. understory 3. forest floor?",
                        desert, "1", new Key(desert, forest)), desert));

        forest.addObjet(
                new Letter(new Enigme(
                        "What is the largest freshwater lake in the world, by surface area? 1. Lake Superior 2. Lake Baikal 3. Leman",
                        forest, "1", new Key(forest, lake)), forest));

        lake.addObjet(
                new Letter(new Enigme("Ponds can be man-made or natural. 1. false 2. true",
                        lake, "2", new Key(lake, pond)), lake));

        pond.addObjet(
                new Letter(new Enigme("Final question: did you like this game? ;-) 1. loved it 2. nope",
                        pond, "1", new Key(pond, arrival)), lake));


        // ajoute les commandes
        registry = new CommandRegistry();

        CommandHelp cmdHelp = new CommandHelp(registry);
        registry.registerCommand(cmdHelp);

        CommandMap cmdMap = new CommandMap();
        registry.registerCommand(cmdMap);

        CommandMove cmdMove = new CommandMove();
        registry.registerCommand(cmdMove);

        CommandLook cmdLook = new CommandLook(this);
        registry.registerCommand(cmdLook);

        CommandTake cmdTake = new CommandTake();
        registry.registerCommand(cmdTake);

        CommandInspect cmdInspect = new CommandInspect();
        registry.registerCommand(cmdInspect);

        CommandUse cmdUse = new CommandUse();
        registry.registerCommand(cmdUse);

        CommandSee cmdSee = new CommandSee();
        registry.registerCommand(cmdSee);

        CommandSay cmdSay = new CommandSay();
        registry.registerCommand(cmdSay);

        CommandTeleport cmdTeleport = new CommandTeleport();
        registry.registerCommand(cmdTeleport);

    }

    public void run() {
        System.out.println("Running game...");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");

            
            String input = scanner.nextLine().trim(); // .trim() enlève les espaces en début et fin de la saisie
            if (input.isEmpty())
                continue;

         
            String[] parts = input.split("\\s+");    // sépare saisie en plusieurs mots

           
            String commandName = parts[0].toLowerCase();  // nom de la commande (move/ map...)
            String[] args = Arrays.copyOfRange(parts, 1, parts.length); 

            Command command = registry.getCommand(commandName);

            // a revoir - OK 
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

    public Zone getZoneByName(String zoneName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getZoneByName'");
    }

}