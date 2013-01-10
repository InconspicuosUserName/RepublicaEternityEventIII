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
	private EternityMain em;
	
	public EternityCommandExecutor(EternityMain em) {
		super();
		this.em = em;
	}

	private EternityItems im = new EternityItems();
	
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
		
		if (c.getLabel().equalsIgnoreCase("TestSFX")) {
			if (cs.isOp()) {
				SoundEffectsManager.playSpawnSound(((Player) cs).getLocation());
			}
		}
		
		if(c.getLabel().equalsIgnoreCase("Caesar")){
			if(cs.isOp()){
				Random rand = new Random(4);
				int temp = rand.nextInt();
				
				Player[] players = em.getServer().getOnlinePlayers();
				for(int i = 0; /*i < temp &&*/ i < players.length; i++){
					int temp2 = rand.nextInt();
					Player player = players[/*temp2*/i];
					player.sendMessage(ChatColor.GREEN + "A book falls from the sky.");
					Location l1 = player.getLocation();
					l1.add(2, 5, 0);
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
