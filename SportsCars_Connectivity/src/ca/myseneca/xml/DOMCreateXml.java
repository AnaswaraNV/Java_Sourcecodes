package ca.myseneca.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.myseneca.database.QuerySportsDB;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DOMCreateXml {

	public static void main(String argv[]) {

		try {

			QuerySportsDB queryObject = new QuerySportsDB();
			//String colNameArray[] =(queryObject.getColList()).toArray(new String[(queryObject.getColList()).size()]);

			//Object objectArray[] = (queryObject.getObj()).toArray(new Object[(queryObject.getObj()).size()]);
			ArrayList<String> colList = queryObject.getColList();
			Map<Integer, List<String>> rowMap = queryObject.executeDBFetch();
			
			System.out.println("here" + rowMap);
			//System.out.println("colNameLength" +colNameArray.length);

			//System.out.println("Object array length " + objectArray.length);
			//int count = (int) Math.round(Math.sqrt(colNameArray.length));
			//System.out.println("count is : " + count);
			// Create a DocumentBuilder
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// Create an xml Document
			Document doc = dBuilder.newDocument();
			
			// Create the root element
			Element rootElement = doc.createElement("CARS");
			doc.appendChild(rootElement);

			for(int i = 0 ; i < rowMap.keySet().size() ; i++ ) { 
				List<String> row = rowMap.get(i);
				
				Element car = null;
				car = doc.createElement("CAR");
				rootElement.appendChild(car);
				
				System.out.println("Column list is #$#$# " + colList);
				for(int j = 0 ; j < colList.size() ; j++ ) {
				// Create a year element
				Element column = doc.createElement(colList.get(j));
				car.appendChild(column);
				// add text nodes
				System.out.println(row);
				String value = row.get(j);
				column.appendChild(doc.createTextNode(value));	
				}
			}				
			// write the content into xml file

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			Transformer transformer = transformerFactory.newTransformer();

			//Acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.

			DOMSource source = new DOMSource(doc);

			/*Acts as an holder for a transformation result, 
			which may be XML, plain Text, HTML, or some other form of markup.
			 */
			StreamResult result = new StreamResult(new File("cars.xml"));
			transformer.transform(source, result);
			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);

			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}