
import javax.swing.*;
import java.awt.event.*;

class FormatException2 {

	public static void main(String[] args) {

		String s = JOptionPane.showInputDialog( null, "How many people are waiting?" );


		int value = -123;

		try {
				value = Integer.parseInt( s );

		}
		catch( NumberFormatException nfe ) {

				System.out.println( "invalid input!( " + s + ")" );
		}

		System.out.println( "value: " + value );
	}

}