package republicaEternityEventIII.republica.devteam;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EternityCommandExecutor implements CommandExecutor{

	private String ziminiar;
	private Ziminiar z;
	private EternityMain em = new EternityMain();
	private EternityItems im = new EternityItems();
	
	private Player p[] = em.getServer().getOnlinePlayers();
	
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
				Random rand = new Random(4);
				int temp = rand.nextInt();
				
				for(int i = 0; i < temp && i < p.length; i++){
					int temp2 = rand.nextInt();
					Player player = p[temp2];
					player.sendMessage(ChatColor.GREEN + "A book falls from the sky.");
					Location l1 = player.getLocation();
					player.getWorld().dropItemNaturally(l1, im.caesarBook());
				}
				
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
