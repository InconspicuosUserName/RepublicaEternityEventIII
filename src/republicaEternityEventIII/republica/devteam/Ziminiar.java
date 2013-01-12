package republicaEternityEventIII.republica.devteam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Ziminiar {
	
	private int ZiminiarHealth;
	private Player Ziminiar;
	
	public Ziminiar(Player ziminiar){
		Ziminiar = ziminiar;
		ziminiar.setDisplayName(ChatColor.BLACK + "Ziminiar");
		Bukkit.broadcastMessage(ChatColor.BLACK + "Ziminiar" + ChatColor.WHITE + " has risen!");
		remakeZiminiar(); //Edits the player's attributes.
	}
	
	public Player returnZiminiar(){
		return Ziminiar;
	}
	
	private void remakeZiminiar(){
		changeZiminiarNameplate();
		DisguiseCraftIntermediary.dragonify(Ziminiar.getName());
		ziminiarHealth();
		ziminiarWeapons();
		ziminiarArmor();
	}
	
	private void changeZiminiarNameplate(){
		//Perolan's NBT code here
	}
	
	private void ziminiarHealth(){
		ZiminiarHealth = 2000;
	}
	
	private void ziminiarWeapons(){
		//TODO: Give Ziminiar his weapons
	}
	
	private void ziminiarArmor(){
		//TODO: Give Ziminiar his armor and equip it
	}
	
	private void damageZiminiarHealth(int i){
		ZiminiarHealth -= i;
		
		if(ZiminiarHealth % 25 == 0){
			Bukkit.broadcastMessage(ChatColor.BLACK + "Ziminiar" + ChatColor.RED + " has " + ChatColor.BLUE + ZiminiarHealth + ChatColor.RED + " remaining");
			//Broadcasts when Ziminiar has been taking down 25 health
		}
	}
	
	public void ZiminiarHit(Player pl){
		damageZiminiarHealth(1);
		//I might change this later...
		
		MagicalStorage.incrementPlayerScore(pl.getName(), 1);
	}
}
