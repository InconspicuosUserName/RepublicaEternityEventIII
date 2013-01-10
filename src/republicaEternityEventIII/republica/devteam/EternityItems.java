package republicaEternityEventIII.republica.devteam;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class EternityItems {
	
	private ItemStack item = null;
	private String page1 = "  He has risen. I cannot risk returning to the "
						+ "City Forums, because he has cultists watching every "
						+ "corner. I said that what you set in motion cannot "
						+ "be undone, and I fear for your saftey. I have taken "
						+ "to the skies, I'm not sure whether you will get "
						+ "these";
	private String page2 = "messages, so I will continue to drop these "
						+ "from my airship. He is no longer in hiding, he has "
						+ "a fortress that he has made.\n"
						+ "   You will need to battle him, he must be eliminated "
						+ "after this coming battle, it will not be over, more will "
						+ "come in the name of";
	private String page3 = "revenge. His followers have built him "
						+ "a temple, I've watched them sacrifice villagers to him, "
						+ "I can still not forget their screams, and the smell from "
						+ "them being burned alive covers my clothing.\n"
						+ "   You have to hurry, the window of opportunity is "
						+ "closing,";
	private String page4 = "if you delay any further, all will be lost, "
						+ "if it isn't already.\n\n"
						+ "He can only be defeated by §kTHIS WILL PRODUCE RANDOMLY"
						+ "CHANGING TEXT SO IT LOOKS LIKE WE WERE ABOUT TO REVEAL"
						+ "SOMETHING USEFUL BUT THEN WE GOT STOPPED";
	
	public ItemStack caesarBook() {
		if (item != null) {
			return item;
		}
		item = new ItemStack(Material.WRITTEN_BOOK);
		
		BookMeta meta = (BookMeta) item.getItemMeta();
		
		meta.setAuthor("Caesar");
		meta.setTitle("Message");
		
		meta.setPages(page1, page2, page3, page4);
		
		item.setItemMeta(meta);
		
		return item;
	}
	
}
