package str;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapSortTest {

	public static void main(String[] args) {
		Map<String, List<Map<String, Object>>> resultMap = new TreeMap<String, List<Map<String, Object>>>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.equals("PVE战斗力")) {
					return 1;
				} else if (o1.equals("PVP战斗力")) {
					return 9;
				} else if (o1.equals("盒子战斗力")) {
					return 8;
				} else {
					return 0;
				}
			}
		});
		resultMap.put("盒子战斗力", new ArrayList<Map<String,Object>>());
		resultMap.put("PVE战斗力", new ArrayList<Map<String,Object>>());
		resultMap.put("PVP战斗力", new ArrayList<Map<String,Object>>());
		resultMap.put("逗呢", new ArrayList<Map<String,Object>>());
		Set<Entry<String, List<Map<String, Object>>>> entrySet = resultMap.entrySet();
		for (Entry<String, List<Map<String, Object>>> entry : entrySet) {
			System.out.println(entry.getKey());
		}
	}

}
