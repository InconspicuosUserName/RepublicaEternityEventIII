package republicaEternityEventIII.republica.devteam;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Server;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import com.avaje.ebean.EbeanServer;
import republicaEternityEventIII.republica.devteam.FireworkDelayedBurster;

public class EternityListener implements Listener, Plugin{
	
	private EternityMain em;
	public EternityListener(EternityMain em) {
		super();
		this.em = em;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e)
	{
		Player p = (Player) e.getEntity();
		 if(p.isOp()){
			 //Sorry for this spam, but I'm not risking shit being fucked up now!
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
	
	
	@EventHandler
	public void onPlayerDamageMethod(EntityDamageByEntityEvent e){
		
		if(e.getEntity() instanceof Player && e.getEntity().getLastDamageCause() instanceof Player){
			if(em.getZiminiarPlayer() == e.getEntity()){
				Player pl = (Player) (e.getEntity());
				em.boss.ZiminiarHit((Player) (pl.getLastDamageCause()));
				pl.setHealth(20);
			}
		}
		
	}
	
	@EventHandler
	public void onPlayerPunchThing(PlayerInteractEvent e) {
		SignPunchingOMatic.checkFor(e);
		if (em.boss != null) {
			em.boss.checkForSpells(e);
		}
		if (SignPunchingOMatic.changed()) {
			em.saveResultsSignLocation();
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1,
			String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FileConfiguration getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getDataFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EbeanServer getDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginDescriptionFile getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginLoader getPluginLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getResource(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNaggable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reloadConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDefaultConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveResource(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNaggable(boolean arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
