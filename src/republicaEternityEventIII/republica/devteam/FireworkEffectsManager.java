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
		fem.addEffects(FireworkEffect.builder().flicker(true).with(Type.BURST).withColor(Color.GREEN).withFade(Color.GREEN).build());
		feGreen.setFireworkMeta(fem);
		fem.addEffects(FireworkEffect.builder().flicker(false).with(Type.STAR).withColor(Color.WHITE).withFade(Color.WHITE).build());
		feWhite.setFireworkMeta(fem);
		fem.addEffects(FireworkEffect.builder().flicker(true).with(Type.BALL_LARGE).withColor(Color.YELLOW).withFade(Color.YELLOW).build());
		feYellow.setFireworkMeta(fem);
		fem.addEffects(FireworkEffect.builder().flicker(false).with(Type.BURST).withColor(Color.PURPLE).withFade(Color.PURPLE).build());
		fePurple.setFireworkMeta(fem);
	}
	
}
