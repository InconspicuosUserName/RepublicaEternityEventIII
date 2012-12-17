package republicaEternityEventIII.republica.devteam;

import org.bukkit.Material;
import org.bukkit.craftbukkit.inventory.CraftItemStack;

import net.minecraft.server.ItemStack;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTagString;

public class EternityItems {
	
	private ItemStack cb;
	private CraftItemStack cbb = new CraftItemStack(Material.WRITTEN_BOOK);
	private String cbpI = "		He has risen. I cannot risk returning to the"
						+ "City Forums, because he has cultists watching every"
						+ "corner. I said that what you set in motion cannot"
						+ "be undone, and I fear for your saftey. I have taken"
						+ "to the skies, I'm not sure whether you will get"
						+ "these messages, so I will continue to drop these"
						+ "from my airship. He is no longer in hidding, he has"
						+ "a fortress that he has made.";
	private String cbpII= "		You will need to battle him, he must be eliminated"
						+ "after this coming battle, it will not be over, more will"
						+ "come in the name of revenge. His followers have built him"
						+ "a temple, I've watched them sacrifice villagers to him,"
						+ "I can still not forget their screams, and the smell from"
						+ "them being burned alive covers my clothing."
						+ "		You have to hurry, the window of opportunity is"
						+ "closing, if you delay any further, all will be lost,";
	private String cbpIII="if it isn't already.";
	
	public CraftItemStack caesarBook(){
		cb = cbb.getHandle();
		
		NBTTagCompound cbNBT = new NBTTagCompound();
		
		cbNBT.setString("title", "Message");
		cbNBT.setString("author", "Caesar");
		
		NBTTagList cbPages = new NBTTagList();
		
		cbPages.add(new NBTTagString("page1", cbpI));
		cbPages.add(new NBTTagString("page2", cbpII));
		cbPages.add(new NBTTagString("page3", cbpIII));
		
		cbNBT.set("pages", cbPages);
		
		cb.setTag(cbNBT);
		
		return new CraftItemStack(cb);
	}
	
	private void setItemName(String s){
		
	}
	
}
