package commands;

import joueur.Player;
import worldmap.WorldMap;
import zone.Zone;

public class CommandMove extends Command {
    private String direction;
    private WorldMap worldMap;


    public CommandMove(String direction, WorldMap worldMap) {
        super("move", "Be able to move foward, backwards, left or right.");
        this.direction = direction;
        this.worldMap = worldMap;

        if (!(direction.equals("left")||direction.equals("right")||direction.equals("top")||direction.equals("bottom"))) {
            System.out.println("The direction isn't valid.");
        }
        else {
            this.direction = direction;
    }

    @Override
    protected String doExecute(Player player, Zone curentZone) {
        int row = player.getRow();
        int column = player.getColumn();

        int newRow = row;
        int newColumn = column;

        // la du coup je voulais mettre une calcul et verification de la nouvelle position
        //mais je ne sais pas trop comment faire
        //mais je penses qu'il faut utiliser des if et tout



    }
       
}
    
