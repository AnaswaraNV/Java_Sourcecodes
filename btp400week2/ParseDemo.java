
// an example that uses a Java wrapper class

import javax.swing.*;

public class ParseDemo {

   public static void main( String args [] ) {


   	String inputString;

   	inputString = JOptionPane.showInputDialog( "How old are you?" );

   	int age;

   	age = Integer.parseInt( inputString );

   	System.out.println( "You are now " + age + " years old.\n" +
   	                    "Your age will be " + (++age) + " next year!" );

   	// Double.paresDouble

   }

}