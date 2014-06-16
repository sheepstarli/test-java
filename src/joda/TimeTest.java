package joda;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;

public class TimeTest {
	public static void main(String[] argvs) {
		DateTime dt = new DateTime(new Date());
		MutableDateTime mdt  = dt.toMutableDateTime();
		mdt.addDays(-1);
		System.out.print(mdt.toDate());
	}
}
