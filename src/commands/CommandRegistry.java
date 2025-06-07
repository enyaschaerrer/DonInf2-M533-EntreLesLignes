package commands;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    
    private Map<String, Command> commands = new HashMap<>();

    public void registerCommand(Command command) {
        commands.put(command.getVerb(), command); // verbe de la commande et la commande
    }

    public Command getCommand(String verb) {
        return commands.get(verb);
    }

    public String afficherCommandes() {
        String result = "";
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            String verb = entry.getKey();
            String description = entry.getValue().getDescription();
            result = result + verb + " - " + description + "\n";
        }
        return result;
       
    }

    public Map<String, Command> getCommands() {
        return this.commands;
    }
}
