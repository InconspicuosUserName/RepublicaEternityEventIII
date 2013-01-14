package republicaEternityEventIII.republica.devteam;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import pgDev.bukkit.DisguiseCraft.DisguiseCraft;
import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;
import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;

public class DisguiseCraftIntermediary {
	private static DisguiseCraftAPI api;
	
	public static void init() {
		api = DisguiseCraft.getAPI();
	}
	
	public static void dragonify(String userName) {
		Player player = Bukkit.getPlayer(userName);
		Disguise dragon = new Disguise(api.newEntityID(), DisguiseType.EnderDragon);
		api.disguisePlayer(player, dragon);
	}
	
	public static void undragonify(String userName) {
		api.undisguisePlayer(Bukkit.getPlayer(userName));
	}
}
