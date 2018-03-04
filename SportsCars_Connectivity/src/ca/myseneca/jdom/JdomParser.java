package ca.myseneca.jdom;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JdomParser {

	public static void main(String[] args) {
	      try {
	    	  
	         // Create a DocumentBuilder
			/* Builds a JDOM Document using a SAX parser.
				SAXbuilder uses a third-party SAX parser (chosen by JAXP by default, o
				r you can configure it manually) to handle the parsing duties 
				and uses an instance of a SAXHandler to listen to the SAX 
				events in order to construct a document with JDOM content using a JDOMFactory. */
	         SAXBuilder saxBuilder = new SAXBuilder();

	         // Create a Document from a file 
	         File inputFile = new File("cars.xml");
	         Document document = saxBuilder.build(inputFile);

	         

	         // Extract the root element
	         Element classElement = document.getRootElement();
	         System.out.println("Root element: " + classElement.getName());
	         
	         // Examine sub-elements
	         List<Element> carList = classElement.getChildren();
	         System.out.println("================================");

	         for (int i = 0; i < carList.size(); i++) {    
	        	 
	        	// Examine a single sub-element
	            Element car = carList.get(i);
	            System.out.println("\nElement :" 
	               + car.getName());
	            // Examine the attribute
	            //Attribute attribute =  student.getAttribute("sid");
	            //System.out.println("Student ID : " 
	              // + attribute.getValue() );
	            
	            // Examine the sub-text nodes and print out
	            System.out.println("Year : " + car.getChild("YEAR").getText());
	            System.out.println("Make : "+ car.getChild("MAKE").getText());
	            System.out.println("Model : "+ car.getChild("MODEL").getText());
	            System.out.println("Price : "+ car.getChild("PRICE").getText());	            		
	         }
	      }catch(JDOMException e){
	         e.printStackTrace();
	      }catch(IOException ioe){
	         ioe.printStackTrace();
	      }
	   }
	}
