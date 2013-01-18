package republicaEternityEventIII.republica.devteam;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkEffectsManager {

	public static void playShow(Location argL, World argW){
		Firework feRed = argW.spawn(argL, Firework.class);
		Firework feBlue = argW.spawn(argL, Firework.class);
		Firework feGreen = argW.spawn(argL, Firework.class);
		Firework feWhite = argW.spawn(argL, Firework.class);
		Firework feYellow = argW.spawn(argL, Firework.class);
		Firework fePurple = argW.spawn(argL, Firework.class);
		
		buildFireworks(feRed, feBlue, feGreen, feWhite, feYellow, fePurple);
	}
	
	private static void buildFireworks(Firework feRed, Firework feBlue, Firework feGreen, Firework feWhite, Firework feYellow, Firework fePurple){
		FireworkMeta femRed = feRed.getFireworkMeta();
		femRed.addEffects(FireworkEffect.builder().flicker(false).with(Type.BALL_LARGE).withColor(Color.RED).withFade(Color.RED).build());
		feRed.setFireworkMeta(femRed);
		
		FireworkMeta femBlue = feBlue.getFireworkMeta();
		femBlue.addEffects(FireworkEffect.builder().flicker(false).with(Type.BALL).withColor(Color.BLUE).withFade(Color.BLUE).build());
		feBlue.setFireworkMeta(femBlue);
		
		FireworkMeta femGreen = feGreen.getFireworkMeta();
		femGreen.addEffects(FireworkEffect.builder().flicker(true).with(Type.BURST).withColor(Color.GREEN).withFade(Color.GREEN).build());
		feGreen.setFireworkMeta(femGreen);
		
		FireworkMeta femWhite = feWhite.getFireworkMeta();
		femWhite.addEffects(FireworkEffect.builder().flicker(false).with(Type.STAR).withColor(Color.WHITE).withFade(Color.WHITE).build());
		feWhite.setFireworkMeta(femWhite);
		
		FireworkMeta femYellow = feYellow.getFireworkMeta();
		femYellow.addEffects(FireworkEffect.builder().flicker(true).with(Type.BALL_LARGE).withColor(Color.YELLOW).withFade(Color.YELLOW).build());
		feYellow.setFireworkMeta(femYellow);
		
		FireworkMeta femPurple = fePurple.getFireworkMeta();
		femPurple.addEffects(FireworkEffect.builder().flicker(false).with(Type.BURST).withColor(Color.PURPLE).withFade(Color.PURPLE).build());
		fePurple.setFireworkMeta(femPurple);
	}
	
}
