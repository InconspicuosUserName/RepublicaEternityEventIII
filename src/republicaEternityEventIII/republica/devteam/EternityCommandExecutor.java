package republicaEternityEventIII.republica.devteam;

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
	private CommandSender lastCS;
	private static EternityCommandExecutor INSTANCE = null;
	
	public EternityCommandExecutor(EternityMain em) {
		super();
		if (INSTANCE != null) {
			throw new RuntimeException("Instantiated multiple EternityCommandExecutors");
		}
		this.em = em;
		INSTANCE = this;
	}
	
	public static void sendMessageToLastSender(String message) {
		INSTANCE.lastCS.sendMessage(message);
	}
	
	@Override
    public boolean onCommand(CommandSender cs, Command c, String l, String[] args) {
		lastCS = cs;
	    
		if(c.getLabel().equalsIgnoreCase("Ziminiar")){
			if(cs.isOp()){
				if (args.length == 1) {
					ziminiar = args[0];
					//Code to change player into Ziminiar here
					z = new Ziminiar(getPlayerByNameOf(ziminiar));
					setZiminiarInMain(z);
					return true;
				}
			}
		}
		
		if (c.getLabel().equalsIgnoreCase("setResultsSign")) {
			if (cs.isOp()) {
				SignPunchingOMatic.change();
				cs.sendMessage("Punch a sign to set it.");
			}
		}
		
		if (c.getLabel().equalsIgnoreCase("TestSFX")) {
			if (cs.isOp()) {
				SoundEffectsManager.playSpawnSound(((Player) cs).getLocation());
				return true;
			}
		}
		
		if (c.getLabel().equalsIgnoreCase("AddTestData")) {
			if (cs.isOp()) {
				MagicalStorage.incrementPlayerScore(cs.getName(), 1337);
				MagicalStorage.incrementPlayerScore("AnotherPlayer", 19);
				MagicalStorage.incrementPlayerScore("OneMorePlayer", 21);
				return true;
			}
		}
		
		if (c.getLabel().equalsIgnoreCase("getBook")) {
			if (cs.isOp()) {
				EternityItems.loadResults();
				((Player) cs).getInventory().addItem(EternityItems.getResultsBook());
				return true;
			}
		}
		
		if (c.getLabel().equalsIgnoreCase("saveResults")) {
			if (cs.isOp()) {
				EternityItems.saveResults();
				return true;
			}
		}
		
		if(c.getLabel().equalsIgnoreCase("Caesar")){
			if(cs.isOp()){
//				Random rand = new Random(4);
//				int temp = rand.nextInt();
				
				Player[] players = em.getServer().getOnlinePlayers();
				for(int i = 0; /*i < temp &&*/ i < players.length; i++){
//					int temp2 = rand.nextInt();
					Player player = players[/*temp2*/i];
					player.sendMessage(ChatColor.GREEN + "A book falls from the sky.");
					Location l1 = player.getLocation();
					l1.add(2, 5, 0);
					player.getWorld().dropItemNaturally(l1, EternityItems.caesarBook());
				}
				
				return true;
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
