
import javax.swing.*;
import java.awt.event.*;

class FormatException {

	public static void main(String[] args) {

		String s = JOptionPane.showInputDialog( null, "How many people are waiting?" );


		int value;

		value = Integer.parseInt( s );

		System.out.println( "value: " + value );
	}


}