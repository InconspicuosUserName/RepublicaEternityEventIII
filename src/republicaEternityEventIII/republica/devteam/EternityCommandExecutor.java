package republicaEternityEventIII.republica.devteam;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EternityCommandExecutor implements CommandExecutor{

	private String ziminiar;
	private Ziminiar z;
	private EternityMain em = new EternityMain();
	
	@Override
    public boolean onCommand(CommandSender cs, Command c, String l, String[] args) {
	    
		if(c.getLabel().equalsIgnoreCase("Ziminiar")){
			if(cs.isOp()){
				ziminiar = args[0];
				//Code to change player into Ziminiar here
				z = new Ziminiar(getPlayerByNameOf(ziminiar));
				setZiminiarInMain(z);
				return false;
			}
		}
		
		if(c.getLabel().equalsIgnoreCase("Caesar")){
			if(cs.isOp()){
				//Code to spawn a random amount of books with a warning from caesar near players
				return false;
			}
		}
		
	    return false;
    }
	
	private Player getPlayerByNameOf(String s){
		return em.getZiminiarTargetPlayer(s);
	}
	
	private void setZiminiarInMain(Ziminiar zz){
		passZiminiarToMain(zz);
		em.ZiminiarPlayer(zz.returnZiminiar());
	}
	
	private void passZiminiarToMain(Ziminiar zz){
		em.ziminiarClass(zz);
	}
	
}
