
//Core Java II, Example 1-2
// two threads: GUI and bounce the ball
// click on the "Start" button many times => start many threads!

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BallBouncing2 {

	public static void main(String[] args) {

		JFrame frame = new BounceThreadFrame();
		// superclass	   // subclass

		frame.setVisible(true);
	}
}

class BounceThreadFrame extends JFrame {

	private JPanel drawPanel;

	public BounceThreadFrame() {

		setSize(300, 200);

		setTitle( "Ball Bouncing" );

		Container c = getContentPane();

		drawPanel = new JPanel();

		JPanel p = new JPanel();

		addButton( p, "Start",
			   new ActionListener() {
		                  public void actionPerformed(ActionEvent e)
                                  { Ball b = new Ball( drawPanel ); // *** create a ball thread
                                    b.start();                      // *** start a thread
				  }
				}
			 );

		addButton( p, "Close", new ActionListener() {
                                           public void actionPerformed(ActionEvent e)
					   { System.exit(0); }
				       }
			 );

		c.add( drawPanel, "Center" );
                c.add( p,         "South"  );

		// register a listener for the JFrame
		addWindowListener( new WindowAdapter() {
			 public void windowClosing(WindowEvent e)
			             { System.exit(0); }
		         }
		);
	} // end constructor

	private void addButton(Container ct, String title, ActionListener a) {

 		JButton b = new JButton( title );

		ct.add( b );

		b.addActionListener( a );
	}
}

// subclass of Thread
class Ball extends Thread {

	private JPanel box;
	private static final int XSIZE = 10;
	private static final int YSIZE = 10;

	private int x = 0;
	private int y = 0;
	private int dx = 2;
	private int dy = 2;

	public Ball( JPanel  b) { box = b; }

	public void draw() { // draw the ball

		Graphics g = box.getGraphics();

		g.fillOval( x, y, XSIZE, YSIZE );
		g.dispose();
	}

	public void move() {

		// *** if ( !box.isVisible() ) return;

		Graphics g = box.getGraphics();

		g.setXORMode( box.getBackground() );  //???

		g.fillOval( x, y, XSIZE, YSIZE );

		// calculate the new position
		x += dx;	y += dy;

		// check the boundary conditions
		Dimension d = box.getSize();

		if (x<0) { x=0; dx = -dx; }

		if ( x + XSIZE >= d.width) { x = d.width - XSIZE; dx = -dx; }

		if (y<0) { y=0; dy = -dy; }

		if ( y + YSIZE >= d.height ) { y = d.height - YSIZE; dy = -dy; }

		// draw at the new position
		g.fillOval( x, y, XSIZE, YSIZE );

		g.dispose();
	}

	// ovveride the Thread method run()
        // the task of executing the thread(i.e. bouncing the ball)
	public void run() {

	   try {
		draw();

		for(int i=1; i<=2000; i++) {

		   move();    // move the ball

		   sleep(5);  // block the thread
		}
	       }
	   catch( InterruptedException e ) { }

	}
}
