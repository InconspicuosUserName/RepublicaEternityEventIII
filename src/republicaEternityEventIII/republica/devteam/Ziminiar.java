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
	
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Ziminiar's Armor.
		// Todo: Give acctual armor instead of just diamond.
		if (cmd.getName().equalsIgnoreCase("armor"))
		{
			Player player = (Player) sender;
			PlayerInventory inv = player.getInventory();
		
			ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			ItemStack pants = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
			ItemStack helm = new ItemStack(Material.DIAMOND_HELMET, 1);
			ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
			
			//Boot Enchantments, NBT data to be added. Don't worry Prod, I'll do it for you.
			boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
			boots.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
			boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 5);
			boots.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
			boots.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 6);
			
			
			//Helmet Enchantments, same about the NBT.
			helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
			helm.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 3);
			helm.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
			
			//Chestplate Enchantments, NBT yada yada.
			
			chest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
			chest.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 6);
			chest.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 5);
			chest.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
			
			//Leggings Enchantments, NBT? What are you talking about? Why would I mention that again?
			
			pants.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
			pants.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
			pants.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
			pants.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE,5);
			
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
