public interface ICommand {
    String execute(Player player, Zone zone);  
    String getVerb();                          
    String getDescription();                   
}