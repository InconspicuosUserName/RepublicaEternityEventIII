package republicaEternityEventIII.republica.devteam;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkEffectsManager {
	static Firework feRed;
	static Firework feBlue;
	static Firework feGreen;
	static Firework feWhite;
	static Firework feYellow;
	static Firework fePurple;
	
	public static void playShow(Location argL){
		
	}
	
	private void buildFireworks(){
		FireworkMeta fem = feRed.getFireworkMeta();
		fem.addEffects(FireworkEffect.builder().flicker(false).with(Type.BALL_LARGE).withColor(Color.RED).withFade(Color.RED).build());
		feRed.setFireworkMeta(fem);
		fem.addEffects(FireworkEffect.builder().flicker(false).with(Type.BALL).withColor(Color.BLUE).withFade(Color.BLUE).build());
		feBlue.setFireworkMeta(fem);
	}
	
}
