
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JdomCreateXml {
	public static void main(String[] args) {

		try {
			// root element
			Element carsElement = new Element("books");
			Document document = new Document(carsElement);

			// Commputer-software-book element
			Element computerSoftwareElement = new Element("Computer-Software");

			// book element 1
			Element bookElement1 = new Element("book");
			bookElement1.setAttribute(new Attribute("cover", "hardcovers"));
			bookElement1.setText("Servlet and JSP");

			// book element 2
			Element bookElement2 = new Element("book");
			bookElement2.setAttribute(new Attribute("cover", "paperbacks"));
			bookElement2.setText("Oracle JDBC");

			computerSoftwareElement.addContent(bookElement1);
			computerSoftwareElement.addContent(bookElement2);

			document.getRootElement().addContent(computerSoftwareElement);

			XMLOutputter xmlOutput = new XMLOutputter();

			// display xml
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(document, System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}