public class CommandMove extends Command {
    private String direction;

    public CommandMove(String direction) {
        super("move", "Be able to move foward, backwards, left or right.");
        this.direction = direction;
    }

    @Override
    protected String doExecute(Player player, Zone zone) {
       
}

