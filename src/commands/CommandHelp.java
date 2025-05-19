public class CommandHelp extends Command {
    private CommandRegistry registry;

    public CommandHelp(CommandRegistry registry) {
        super("help", "Display commands");
        this.registry = registry;
    }

    @Override
    public String execute(Player player, Zone zone) {
        
    }

    @Override
    protected String doExecute(Player player, Zone zone) {
        
    }

}