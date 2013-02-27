package republicaEternityEventIII.republica.devteam;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.generator.ChunkGenerator;
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
		 if (p.hasPermission("ziminiar.level")){
			 p.sendMessage(ChatColor.RED + "Test");
		    	getServer().getScheduler().scheduleSyncRepeatingTask(this, new FireworkDelayedBurster(p), 45L, 45L);    	
		    	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
		               public void run()
		               {
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
