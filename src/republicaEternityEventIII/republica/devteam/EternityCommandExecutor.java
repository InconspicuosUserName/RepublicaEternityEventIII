package republicaEternityEventIII.republica.devteam;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;

public class EternityCommandExecutor implements CommandExecutor{

	private String puppetmaster;
	private Ziminiar ziminiar;
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
					puppetmaster = args[0];
					//Code to change player into Ziminiar here
					ziminiar = new Ziminiar(getPlayerByNameOf(puppetmaster), em);
					setZiminiarInMain(ziminiar);
					return true;
				}
			}
		}
		
		if(c.getLabel().equalsIgnoreCase("fireworks")){
			Player p = (Player) cs;
			if(cs.isOp()){
				for(int i = 0; i < 200; i++){	
				
					 //Spawn the Firework
			            Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
			            FireworkMeta fwm = fw.getFireworkMeta();

			            //random
			            Random ra = new Random();

			            //sets type
			            int rt = ra.nextInt(5) + 1;
			            Type type = Type.BALL;
			            if (rt == 1) type = Type.BALL;
			            if (rt == 2) type = Type.BALL_LARGE;
			            if (rt == 3) type = Type.BURST;
			            if (rt == 4) type = Type.CREEPER;
			            if (rt == 5) type = Type.STAR;

			            //colors
			            //To be Added
			            
			            
			            
			            int r = ra.nextInt(256);
			            int b = ra.nextInt(256);
			            int g = ra.nextInt(256);
			            Color c1 = Color.fromRGB(r, g, b);

			            r = ra.nextInt(256);
			            b = ra.nextInt(256);
			            g = ra.nextInt(256);
			            Color c2 = Color.fromRGB(r, g, b);


			            //effect
			            FireworkEffect effect = FireworkEffect.builder().flicker(ra.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(ra.nextBoolean()).build();

			            //applied effects
			            fwm.addEffect(effect);

			            //random power! moar sulphur!
			            int rp = ra.nextInt(2) + 1;
			            fwm.setPower(rp);

			            //aaaaaand set it
			            fw.setFireworkMeta(fwm);
				 }
			    	p.sendMessage(ChatColor.RED + "Do not release your spirit!");
			    	p.sendMessage(ChatColor.RED + "Seriously though, stay still for two minutes while the fireworks go off.");
			    	
				    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) this, new FireworkDelayedBurster(p), 45L, 45L);    	
				    	
				    	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable(){
				               public void run(){
				                   Bukkit.getScheduler().cancelAllTasks();
				               }
				           }, 2400L);
			}
		}
		
		
		if(c.getLabel().equalsIgnoreCase("nerf")){
			if(cs.isOp()){
				if (args.length == 1) {
					String status = args[0];
					Ziminiar.cooldownEnabled = Boolean.parseBoolean(status);
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
				cs.sendMessage("Books begin to fall!");
				
				Random rand = new Random();
				int temp = rand.nextInt(4);
				int temp2;
				
				Player[] players = em.getServer().getOnlinePlayers();
				for(int i = 0; i < temp && i < players.length; i++){
					temp2 = rand.nextInt(players.length) - 1;
					Player player = players[temp2];
					cs.sendMessage("A book was sent to "+ player.getDisplayName() + ".");
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
		return em.getPlayer(s);
	}
	
	private void setZiminiarInMain(Ziminiar zz){
		passZiminiarToMain(zz);
		em.ZiminiarPlayer(getPlayerByNameOf(puppetmaster));
	}
	
	private void passZiminiarToMain(Ziminiar zz){
		em.ziminiarClass(zz);
	}
	
}
