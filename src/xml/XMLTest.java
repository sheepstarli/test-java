package xml;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLTest {

	public static void main(String[] args) {
		try {
			File file = new File("D:\\xml\\test2.xml");
			SAXReader reader = new SAXReader();
			Document xml = reader.read(file);
			Element ele = xml.getRootElement();
			System.out.println(ele.attribute("id").getValue());
			Iterator<Element> ite = ele.elementIterator();
			while(ite.hasNext()) {
				Element childEle = ite.next();
				System.out.print(childEle.getName());
				System.out.println("-" + childEle.getStringValue());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
