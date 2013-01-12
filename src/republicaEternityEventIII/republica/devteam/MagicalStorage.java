package republicaEternityEventIII.republica.devteam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MagicalStorage {
	private static HashMap<String, Integer> data = new HashMap<String, Integer>();
	
	public static void setPlayerScore(String userName, int score) {
		data.put(userName, score);
	}
	
	public static int getPlayerScore(String userName) {
		return data.containsKey(userName) ? data.get(userName) : 0;
	}
	
	public static void incrementPlayerScore(String userName, int increment) {
		int newScore = getPlayerScore(userName) + increment;
		setPlayerScore(userName, newScore);
	}
	
	private static class PlayerObject implements Comparable<PlayerObject> {
		public String name;
		public int score;
		@Override
		public int compareTo(PlayerObject o) {
			return -(new Integer(score).compareTo(o.score));
		}
		@Override
		public String toString() {
			return name + ":" + score;
		}
	}
	
	public static List<String> getPlayersSortedByScore() {
		List<PlayerObject> objects = new ArrayList<MagicalStorage.PlayerObject>();
		for (String username : data.keySet()) {
			PlayerObject newOBJ = new PlayerObject();
			newOBJ.name = username;
			newOBJ.score = data.get(username);
			objects.add(newOBJ);
		}
		Collections.sort(objects);
		List<String> result = new ArrayList<String>();
		for (PlayerObject obj : objects) {
			result.add(obj.name);
		}
		return result;
	}
}
