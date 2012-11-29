package republicaEternityEventIII.republica.devteam;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EternityMain extends JavaPlugin{
	
	private EternityCommandExecutor ece = new EternityCommandExecutor();
	private EternityListener el = new EternityListener();
	public Ziminiar Z;
	
	private Player Ziminiar;
	private Boolean ZiminiarIntialized = false;
	
	public void onEnable() {
		getLogger().info("Plugin Enabled!");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(el, this);
		
		getCommand("Ziminiar").setExecutor(ece);
		getCommand("Caesar").setExecutor(ece);
	}
	
	public void onDisable() {
		getLogger().info("Plugin Disabled!");
	}
	
	public Player getZiminiarTargetPlayer(String s){
		return getServer().getPlayer(s);
	}
	
	public void ZiminiarPlayer(Player pl){
		Ziminiar = pl;
		ZiminiarIntialized = true;
	}
	
	public Player getZiminiarPlayer(){
		if(ZiminiarIntialized){
			return Ziminiar;
		} else {
			return null;
		}
	}
	
	public void ziminiarClass(Ziminiar z){
		Z = z;
	}
	
}
