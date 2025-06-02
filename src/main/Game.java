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
import commands.CommandUse;
import commands.CommandSave;
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

    private WorldMap worldMap = new WorldMap(2, 6);
    private Player player;
    private CommandRegistry registry = new CommandRegistry();
    private List<Objet> allObjects = new ArrayList<>();
    private Enigme currentEnigme;
    private Zone arrivalZone;

    // pour stocker les cmd dites
    private List<String> cmdSaid = new ArrayList<>();

    public Game() {
        System.out.println("Initializing game...");

        initCommands();
        initZonesObjects();

    }

    private void initCommands() {
        CommandHelp cmdHelp = new CommandHelp(registry);
        registry.registerCommand(cmdHelp);

        registry.registerCommand(new CommandMap());
        registry.registerCommand(new CommandMove());
        registry.registerCommand(new CommandLook(this));
        registry.registerCommand(new CommandTake());
        registry.registerCommand(new CommandInspect());
        registry.registerCommand(new CommandUse());
        registry.registerCommand(new CommandSee());
        registry.registerCommand(new CommandSay());
        registry.registerCommand(new CommandSave());
    }

    private void initZonesObjects() {
        // création de zones
        Zone startZone = new Zone("startZone", "starting zone", false, 0, 0);
        Zone desert = new Zone("desert", "expanse of sand", true, 1, 0);
        Zone forest = new Zone("forest", "expanse of fir trees", true, 1, 1);
        Zone lake = new Zone("lake", "deep water body", true, 0, 1);
        Zone pond = new Zone("pond", "body of stagnant water", true, 0, 2);
        Zone mountains = new Zone("mountains", "rocky peaks", true, 1, 2);
        Zone river = new Zone("river", "quiet flow of water", false, 0, 3);
        Zone castle = new Zone("castle", "beautiful old building", false, 1, 3);
        Zone sea = new Zone("sea", "expanse of salt water", false, 0, 4);
        Zone city = new Zone("city", "large town", false, 1, 4);
        Zone jungle = new Zone("jungle", "dense, tropical forest", false, 1, 5);
        Zone arrival = new Zone("arrival", "success", true, 0, 5);

        this.arrivalZone = arrival;

        // ajout des zones a la map
        worldMap.addZone(startZone);
        worldMap.addZone(desert);
        worldMap.addZone(forest);
        worldMap.addZone(lake);
        worldMap.addZone(pond);
        worldMap.addZone(mountains);
        worldMap.addZone(river);
        worldMap.addZone(castle);
        worldMap.addZone(sea);
        worldMap.addZone(city);
        worldMap.addZone(jungle);
        worldMap.addZone(arrival);

        Inventaire inventaire = new Inventaire();

        player = new Player(inventaire);

        startZone.unlock(); // car joueur commence là
        player.setCurrentZone(startZone);

        // les objets

        startZone.addObjet(
                new Letter(new Enigme("What is the biggest desert in the world? 1. Sahara 2. Kalahari 3. Antartica",
                        startZone, "3", new Key(startZone, desert)), startZone));

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
                new Letter(new Enigme("What's the altitude of the Mount Everest? 1. 8001m 2. 8849m 3. 9023m",
                        pond, "2", new Key(pond, mountains)), pond));

        jungle.addObjet(
                new Letter(new Enigme("Final question: did you like this game? ;-) 1. loved it 2. nope",
                        jungle, "1", new Key(jungle, arrival)), jungle));

    }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Running game...");

        System.out.println(
                "Welcome to the Game of Tudum Tudum. You shall inspect the areas and resolve riddles to unlock other areas and move. A surprise is waiting for you at the arrival.");
        System.out.println(
                "At any time, feel free to type 'help' to see all the commands available. ");
                System.out.println("The game is designed to move like a snake: down right up right...");

        System.out.println("Type 1 to start a new game or 2 to load the last save.");

        String choice = scanner.nextLine();

        if (choice.equals("2")) {
            this.getCmdSave().readPastCmd(this);
        }

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

            // si commande ok
            if (command != null) {

                command.execute(this, args);

                // ajouter a listes cmd tapées
                cmdSaid.add(input);

            } else {
                System.out.println("Command unknown. Say 'help' to get the list of all the commands available.");
            }

            if (this.getPlayer().getCurrentZone().equals(arrivalZone)) {
                System.out.println(
                        "You won !!!!!!! The surprise is : you have to tell somebody close to you that you love them. SPREAD LOVE YOUHOU");
            }
        }
    }

    // save

    public List<String> getCommandHistory() {
        return this.cmdSaid;
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

    public void setCurrentEnigme(Enigme enigme) {
        this.currentEnigme = enigme;
    }

    public Enigme getCurrentEnigme() {
        return this.currentEnigme;
    }

    public CommandSave getCmdSave() {
        return (CommandSave) this.registry.getCommand("save");
    }

    public CommandRegistry getRegistry() {
        return this.registry;
    }

}
