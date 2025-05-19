public class CommandInspect extends Command {
    private String objectName;

    public CommandInspect(String objectName) {
        super("inspect", "Command to inspect an object.");
        this.objectName = objectName;
    }

    @Override
    protected String doExecute(Player player, Zone zone) {
        
}
