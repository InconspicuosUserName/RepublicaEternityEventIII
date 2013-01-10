package republicaEternityEventIII.republica.devteam;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class EternityItems {
	
	private ItemStack item = null;
	private String page1 = "		He has risen. I cannot risk returning to the"
						+ "City Forums, because he has cultists watching every"
						+ "corner. I said that what you set in motion cannot"
						+ "be undone, and I fear for your saftey. I have taken"
						+ "to the skies, I'm not sure whether you will get"
						+ "these messages, so I will continue to drop these"
						+ "from my airship. He is no longer in hidding, he has"
						+ "a fortress that he has made.";
	private String page2= "		You will need to battle him, he must be eliminated"
						+ "after this coming battle, it will not be over, more will"
						+ "come in the name of revenge. His followers have built him"
						+ "a temple, I've watched them sacrifice villagers to him,"
						+ "I can still not forget their screams, and the smell from"
						+ "them being burned alive covers my clothing."
						+ "		You have to hurry, the window of opportunity is"
						+ "closing, if you delay any further, all will be lost,";
	private String page3="if it isn't already.";
	
	public ItemStack caesarBook() {
		if (item != null) {
			return item;
		}
		item = new ItemStack(Material.WRITTEN_BOOK);
		
		BookMeta meta = (BookMeta) item.getItemMeta();
		
		meta.setAuthor("Caesar");
		meta.setTitle("Message");
		
		meta.setPages(page1, page2, page3);
		
		item.setItemMeta(meta);
		
		return item;
	}
	
}
