package str;

import org.apache.commons.lang.math.NumberUtils;


public class TimeStrTest {

	public static void main(String[] args) {
		String nowStr = "22:00";
		String startTime = "06:00";
		String endTime = "23:00";
		String[] nowStrArr = nowStr.split(":");
		String[] startTimeArr = startTime.split(":");
		String[] endTimeArr = endTime.split(":");
		Integer nowHour = Integer.parseInt(nowStrArr[0]);
		Integer nowMinutes = Integer.parseInt(nowStrArr[1]);
		Integer startHour = Integer.parseInt(startTimeArr[0]);
		Integer startMinutes = Integer.parseInt(startTimeArr[1]);
		Integer endHour = Integer.parseInt(endTimeArr[0]);
		Integer endMinutes = Integer.parseInt(endTimeArr[1]);
		if (true == compareTime(startHour, startMinutes, endHour, endMinutes)) {
			if (true == compareTime(nowHour, nowMinutes, startHour, startMinutes)) {
				System.out.println("不发送1");
			} else if (false == compareTime(nowHour, nowMinutes, endHour, endMinutes)) {
				System.out.println("不发送2");
			} else {
				System.out.println("发送1");
			}
		} else {
			if (true == compareTime(nowHour, nowMinutes, startHour, startMinutes) &&  false == compareTime(nowHour, nowMinutes, endHour, endMinutes)) {
				System.out.println("不发送3");
			} else {
				System.out.println("发送2");
			}
		}
	}
	
	public static boolean compareTime(Integer nowHour, Integer nowMinutes, Integer destHour, Integer destMinutes) {
		System.out.println(nowHour + ":" + nowMinutes + "      " + destHour + ":" + destMinutes);
		if (nowHour > destHour) {
			return true;
		} else if (nowHour == destHour) {
			if (nowMinutes >= destMinutes) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private static void checkTime(String time) {
		String[] timeArr = time.split(":");
		if (timeArr.length != 2) {
			System.out.println(1);
		}
		if (NumberUtils.isNumber(timeArr[0]) == false) {
			System.out.println(2);
		}
		if (NumberUtils.isNumber(timeArr[1]) == false) {
			System.out.println(3);
		}
		Integer hour = Integer.parseInt(timeArr[0]);
		Integer minutes = Integer.parseInt(timeArr[1]);
		System.out.println(hour + ":" + minutes);
		if (hour < 0 || hour > 24) {
			System.out.println(4);
		}
		if (minutes < 0 || minutes > 60) {
			System.out.println(5);
		}
		System.out.println(6);
	}

}
