package math;

import java.math.BigDecimal;

public class DoubleTest {

	public static void main(String[] args) {
		double width = 640;
		double height = 960;
		System.out.println(Math.abs(width / height));
		BigDecimal widthb = new BigDecimal(640);
		BigDecimal heightb = new BigDecimal(960);
		System.out.println(widthb.divide(heightb));
	}

}
