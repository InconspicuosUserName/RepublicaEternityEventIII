package republicaEternityEventIII.republica.devteam;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EternityListener implements Listener{
	
	private EternityMain em;
	public EternityListener(EternityMain em) {
		super();
		this.em = em;
	}

	private Player pl;
	
	public void onPlayerDamageMethod(EntityDamageEvent e){
		
		if(e.getEntity() instanceof Player){
			if(em.getZiminiarPlayer() == e.getEntity()){
				pl = (Player) e.getEntity();
				em.boss.ZiminiarHit((Player) pl.getLastDamageCause());
				pl.setHealth(20);
			}
		}
		
	}
	
}
