public class CommandUse extends Command {
    private String objectName;

    public CommandUse(String objectName) {
        super("use", "Be able to use an obect");
        this.objectName = objectName;
    }

    @Override
    protected String doExecute(Player player, Zone zone) {
        
}