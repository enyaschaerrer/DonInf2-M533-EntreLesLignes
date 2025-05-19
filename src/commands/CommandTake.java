public class CommandTake extends Command {
    private String objectName;

    public CommandTake(String objectName) {
        super("take", "Pick up an object.");
        this.objectName = objectName;
    }

    @Override
    protected String doExecute(Player player, Zone zone) {
       
}