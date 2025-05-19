package commands;

public class CommandMove extends Command {
    private String direction;

    public CommandMove(String direction) {
        super("move", "Be able to move foward, backwards, left or right.");

        if (!(direction.equals("left")||direction.equals("right")||direction.equals("top")||direction.equals("bottom"))) {
            System.out.println("The direction isn't valid.");
        }
        else {
            this.direction = direction;
    }

    @Override
    protected String doExecute(Player player, Zone zone) {
       
}
