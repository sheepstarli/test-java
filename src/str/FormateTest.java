package str;

import java.text.MessageFormat;

public class FormateTest {

	public static void main(String[] args) {
		MessageFormat form = new MessageFormat("(''{0}'', ''{1}'', ''{2}'', ''{3}''),");
		System.out.println(form.format(new Object[] {"李", null,  "晨", "星"}));
	}

}
