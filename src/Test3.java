
public class Test3 {

	public static void main(String[] args) {
		String[] params = new String[] {"achievements", "appearance", "feed", "guild", "hunterPets", "items", "mounts", "pets", "petSlots", "professions", "progression", "pvp", "quests", "reputation", "stats", "talents", "titles"};	
		StringBuilder builder = new StringBuilder();
		if(null != params && params.length > 0) {
			builder.append("?fields=");
			for(String param : params) {
				builder.append(param).append(",");
			}
			builder.deleteCharAt(builder.length() - 1);
		}
		System.out.println(builder.toString());
	}

}
