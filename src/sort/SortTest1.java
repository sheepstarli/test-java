package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.StringUtils;


public class SortTest1 {

	public static void main(String[] args) {
		Title t1 = new Title(2, "10");
		Title t2 = new Title(1, "8.22%");
		Title t3 = new Title(1, "12");
		Title t4 = new Title(1, "8.12%");
		
		List<Title> titleList = new ArrayList<Title>();
		titleList.add(t1);
		titleList.add(t2);
		titleList.add(t3);
		titleList.add(t4);
		
		sort(titleList);
		
		for (Title title : titleList) {
			System.out.println("rarenum:" + title.getRarenum() + " rarememo:" + title.getRarememo());
		}
		
	}
	
	private static void sort(List<Title> list) {
		Collections.sort(list, new Comparator<Title>() {
			@Override
			public int compare(Title o1, Title o2) {
				if (o1.getRarenum() < o2.getRarenum()) {
					return -1;
				} else if (o1.getRarenum() == o2.getRarenum()) {
					String rarememo1 = o1.getRarememo();
					String rarememo2 = o2.getRarememo();
					boolean percento1 = StringUtils.contains(rarememo1, "%");
					boolean percento2 = StringUtils.contains(rarememo2, "%");
					if (percento1 && percento2) {
						String percentNumo1 = StringUtils.split(rarememo1, "%")[0];
						String percentNumo2 = StringUtils.split(rarememo2, "%")[0];
						Double doubleNumo1 = Double.valueOf(percentNumo1);
						Double doubleNumo2 = Double.valueOf(percentNumo2);
						return doubleNumo1.compareTo(doubleNumo2);
					} else if (!percento1 && !percento2) {
						Integer intRarememo1 = Integer.valueOf(rarememo1);
						Integer intRarememo2 = Integer.valueOf(rarememo2);
						return intRarememo1.compareTo(intRarememo2);
					} else {
						if (percento1) {
							return 1;
						} else if (percento2) {
							return -1;
						} 
					}
					return 0;
				} else {
					return 1;
				}
			}
		});
	}
	
	public static class Title {
		
		private Integer rarenum;
		
		private String rarememo;
		
		public Title(Integer rarenum, String rarememo) {
			this.rarenum = rarenum;
			this.rarememo = rarememo;
		}
		
		public Integer getRarenum() {
			return rarenum;
		}

		public void setRarenum(Integer rarenum) {
			this.rarenum = rarenum;
		}

		public String getRarememo() {
			return rarememo;
		}

		public void setRarememo(String rarememo) {
			this.rarememo = rarememo;
		}
		
	}

}
