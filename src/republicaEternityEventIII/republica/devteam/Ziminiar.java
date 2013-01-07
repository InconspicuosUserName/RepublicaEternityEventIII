package republicaEternityEventIII.republica.devteam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Ziminiar {
	
	private int ZiminiarHealth;
	private Player Ziminiar;
	
	public Ziminiar(Player ziminiar){
		Ziminiar = ziminiar;
		Bukkit.broadcastMessage(ChatColor.BLACK + "Ziminiar" + ChatColor.WHITE + " has risen!");
		remakeZiminiar(); //Edits the player's attributes.
	}
	
	public Player returnZiminiar(){
		return Ziminiar;
	}
	
	private void remakeZiminiar(){
		changeZiminiarNameplate();
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
	
		public boolean ZiminiarArmor(CommandSender sender, Command cmd, String label, String[] args) {
				// Ziminiar Armor.
				// Todo: Give acctual armor instead of just diamond.
				if (cmd.getName().equalsIgnoreCase("ziminiararmor"))
				{
					Player player = (Player) sender;
					PlayerInventory inv = player.getInventory();
				
					ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
					ItemStack pants = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
					ItemStack helm = new ItemStack(Material.DIAMOND_HELMET, 1);
					ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
					
					inv.setChestplate(chest);
					inv.setLeggings(pants);
					inv.setHelmet(helm);
					inv.setBoots(boots);
					return true;
				}
				return false;
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
		
		//ThoshasMethod(pl) { pl.damage++ } or something
	}
}
