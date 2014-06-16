package enumtest;

import java.util.HashMap;
import java.util.Map;

public enum CharacterProfileField {

	AIXINNUOSI("aixinnuosi"),
	QUNXINZHINU("qunxinzhinu"),
	PVESCORE("pveScore"),
	MOUNTSNUM("mountsnum"),
	TOTALHONORABLEKILLS("totalHonorableKills"),
	YUANGUWANGZHE("yuanguwangzhe"),
	SOUHUZHEZHIZHANG("souhuzhezhizhang"),
	JULONGZHINU("julongzhinu"),
	YINGZHIAISHANG("yingzhiaishang"),
	SHAFULASI("shafulasi"),
	FENGJIAN("fengjian"),
	LONGFUZHIYA("longfuzhiya"),
	HUIJINGSHIZHE("huijingshizhe"),
	JIACHONGZHIWANG("jiachongzhiwang"),
	ITEMLEVEL("itemlevel"),
	ITEMLEVELEQUIPPED("itemlevelequipped"),
	ACHIEVEMENTPOINTS("achievementPoints"),
	PVPSCORE("pvpScore");
	
	public String value;
	
	private static final Map<String, CharacterProfileField> lookup = new HashMap<String, CharacterProfileField>();
	
	CharacterProfileField(String value) {
		this.value = value;
	}
	
	static {
		for (CharacterProfileField field : values()) {
			lookup.put(field.value, field);
		}
	}
	
	public static CharacterProfileField getCharacterProfileField(String value) {
		return lookup.get(value);
	}
}
