package republicaEternityEventIII.republica.devteam;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

// I AM PUNCHING YOUR SIGN
public class SignPunchingOMatic {
	private static Location signToPunch = null;
	private static boolean changing = false;
	private static boolean changed = false;
	
	public static Location getPlace() {
		return signToPunch;
	}
	
	public static boolean changed() {
		boolean result = changed;
		changed = false;
		return result;
	}
	
	public static void init(Location place) {
		signToPunch = place;
	}
	
	public static void change() {
		changing = true;
	}
	
	public static void checkFor(PlayerInteractEvent e) {
		Block block = e.getClickedBlock();
		if (block == null) return;
		if (block.getLocation().equals(signToPunch)) {
			Player player = e.getPlayer();
			player.getInventory().addItem(EternityItems.getResultsBook());
			player.sendMessage("Here are the annals of the defeat of Ziminiar.");
		} else {
			Material type = block.getType();
			if (changing && (type.equals(Material.SIGN_POST) || type.equals(Material.WALL_SIGN))) {
				signToPunch = block.getLocation();
				changing = false;
				changed = true;
				EternityCommandExecutor.sendMessageToLastSender("Set the results sign!");
			}
		}
	}
}
