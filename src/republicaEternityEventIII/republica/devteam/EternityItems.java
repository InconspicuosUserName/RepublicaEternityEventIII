package republicaEternityEventIII.republica.devteam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public abstract class EternityItems {
	
	private static ItemStack item = null;
	private static String page1 = "  He has risen. I cannot risk returning to the "
						+ "City Forums, because he has cultists watching every "
						+ "corner. I said that what you set in motion cannot "
						+ "be undone, and I fear for your saftey. I have taken "
						+ "to the skies, I'm not sure whether you will get "
						+ "these";
	private static String page2 = "messages, so I will continue to drop these "
						+ "from my airship. He is no longer in hiding, he has "
						+ "a fortress that he has made.\n"
						+ "   You will need to battle him, he must be eliminated "
						+ "after this coming battle, it will not be over, more will "
						+ "come in the name of";
	private static String page3 = "revenge. His followers have built him "
						+ "a temple, I've watched them sacrifice villagers to him, "
						+ "I can still not forget their screams, and the smell from "
						+ "them being burned alive covers my clothing.\n"
						+ "   You have to hurry, the window of opportunity is "
						+ "closing,";
	private static String page4 = "if you delay any further, all will be lost, "
						+ "if it isn't already.\n\n"
						+ "He can only be defeated by " + ChatColor.MAGIC + "THIS WILL PRODUCE RANDOMLY"
						+ "CHANGING TEXT SO IT LOOKS LIKE WE WERE ABOUT TO REVEAL"
						+ "SOMETHING USEFUL BUT THEN WE GOT STOPPED";
	private static String massiveResultsBookTypeThing = null;
	private static ItemStack resultsBook;
	
	public static ItemStack caesarBook() {
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
	
	public static ItemStack getResultsBook() {
		if (resultsBook != null) {
			return resultsBook;
		}
		
		if (massiveResultsBookTypeThing == null) {
			return new ItemStack(Material.AIR);
		}
		
		resultsBook = new ItemStack(Material.WRITTEN_BOOK);
		
		BookMeta resultsMeta = (BookMeta) resultsBook.getItemMeta();
		resultsMeta.setAuthor("mathphreak");
		resultsMeta.setTitle("Eternity III Results");
		
		String[] lines = massiveResultsBookTypeThing.split("\n");
		String page = "";
		for (String line : lines) {
			if (page.length() + 1 + line.length() > 254) {
				resultsMeta.addPage(page);
				page = "";
			}
			page = page + line + " ";
		}
		resultsMeta.addPage(page);
		
		resultsBook.setItemMeta(resultsMeta);
		
		return resultsBook;
	}
	
	public static void loadResults() {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader("eventIIIresults.txt"));
			massiveResultsBookTypeThing = input.readLine();
			while (input.ready()) {
				massiveResultsBookTypeThing = massiveResultsBookTypeThing + "\n" + input.readLine();
			}
		} catch (FileNotFoundException e) {
			// the file wasn't found, meaning the results don't exist, which means the event isn't over
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				// who cares?
			}
		}
	}

	public static void saveResults() {
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter("eventIIIresults.txt"));
			massiveResultsBookTypeThing = "";
			List<String> users = MagicalStorage.getPlayersSortedByScore();
			for (String userName : users) {
				int score = MagicalStorage.getPlayerScore(userName);
				String scoreString = String.valueOf(score);
				int totalLength = userName.length() + scoreString.length();
				int paddingLength = 21 - totalLength;
				StringBuilder builder = new StringBuilder(userName);
				for (int i = 0; i < paddingLength; i++) {
					builder.append(" ");
				}
				builder.append(scoreString);
				output.write(builder.toString() + "\n");
				massiveResultsBookTypeThing = massiveResultsBookTypeThing + builder.toString() + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				// who cares?
			}
		}
	}
	
}
