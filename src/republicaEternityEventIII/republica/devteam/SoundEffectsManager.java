package republicaEternityEventIII.republica.devteam;

import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Firework;

public class SoundEffectsManager {
	
	public static void playSpawnSound(Location place) {
		World world = place.getWorld();
		world.playSound(place, Sound.ENDERDRAGON_DEATH, 10, 1);
	}
}
