package republicaEternityEventIII.republica.devteam;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EternityMain extends JavaPlugin{
	
	private EternityCommandExecutor ece;
	private EternityListener el;
	public Ziminiar boss;
	
	private Player puppetMaster;
	private Boolean ziminiarReady = false;
	
	public void onEnable() {
		getLogger().info("Plugin Enabled!");
		el = new EternityListener(this);
		ece = new EternityCommandExecutor(this);
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(el, this);
		DisguiseCraftIntermediary.init();
	}
	
	public void onDisable() {
		getLogger().info("Plugin Disabled!");
	}
	
	public Player getZiminiarTargetPlayer(String s){
		return getServer().getPlayer(s);
	}
	
	public void ZiminiarPlayer(Player pl){
		puppetMaster = pl;
		ziminiarReady = true;
	}
	
	public Player getZiminiarPlayer(){
		if(ziminiarReady){
			return puppetMaster;
		} else {
			return null;
		}
	}
	
	public void ziminiarClass(Ziminiar z){
		boss = z;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		return ece.onCommand(sender, command, label, args);
	}
	
}
