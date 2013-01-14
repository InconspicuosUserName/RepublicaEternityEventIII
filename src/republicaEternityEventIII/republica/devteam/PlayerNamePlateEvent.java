package republicaEternityEventIII.republica.devteam;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayerNamePlateEvent extends PlayerEvent{
	
	private HandlerList el = new HandlerList();
	private Player pl;
	private String name;

	public PlayerNamePlateEvent(Player who) {
	    super(who);
	    pl = who;
    }

	@Override
    public HandlerList getHandlers() {
	    return el;
    }
	
	public void setNamePlate(String s){
		name = s;
		pl.getName();
	}

	public String getName() {
		return name;
	}
	
}
