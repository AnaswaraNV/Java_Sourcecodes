

import javax.swing.*;
import java.util.*;

public class TokensDemo {

   public static void main( String args [] ) {

   	  	String inputString;

   	  	inputString = JOptionPane.showInputDialog( "Enter a few English words" );

     	System.out.println( inputString );

   		StringTokenizer tokens = new StringTokenizer( inputString );

   		while ( tokens.hasMoreTokens() ) {

   				System.out.println( "... " + tokens.nextToken() );
   		}



  }
}