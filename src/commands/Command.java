public abstract class Command implements ICommand {
    protected String verb;
    protected String description;

    public Command(String verb, String description) {
        this.verb = verb;
        this.description = description;
    }

    public String getVerb() {
        return verb;
    }

    public String getDescription() {
        return description;
    }

    protected boolean canExecute(Player player, Zone zone) {
        return true; 
    }

    protected abstract String doExecute(Player player, Zone zone);
}