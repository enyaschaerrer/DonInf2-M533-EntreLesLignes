public class CommandSay extends Command {
    private String response;

    public CommandSay(String response) {
        super("say", "Answer to solve the ridle");
        this.response = response;
    }

    @Override
    protected String doExecute(Player player, Zone zone) {
        
    }
}
