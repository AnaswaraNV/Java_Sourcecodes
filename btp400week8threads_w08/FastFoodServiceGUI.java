// a multithreaded application
// GUI-based
// related threads that do not interact

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FastFoodServiceGUI extends JFrame {

   private JTextArea[]  displayArea;
   private ServerThread cashiers[];

   private Integer      clients[];
   private Color        colors[] = { Color.green, Color.magenta, Color.orange };

   public FastFoodServiceGUI() {

      super( "Fast Food Service Threads" );

      displayArea = new JTextArea[3];

      Container c = getContentPane();

      JPanel top = new JPanel();
      top.setLayout( new GridLayout(1,3) );

      for (int i=0; i < 3; i++)
          top.add( new JLabel( "Cashier Counter " + (i+1) ) );

      JPanel bottom = new JPanel();

      bottom.setLayout( new GridLayout(1,3) );

      for (int i=0; i < 3; i++) {

          displayArea[i] = new JTextArea( 5, 10);
          displayArea[i].setBackground( colors[i] );

          bottom.add( new JScrollPane( displayArea[i] ) );
     }

     c.add( top, BorderLayout.NORTH );
     c.add( bottom, BorderLayout.CENTER);

     setSize(480, 250);
     show();
   }

   public void startService() {

      int m = 24;                                   // number of customers
      clients = new Integer [m];                    // an array of customers

      for (int i=0; i < clients.length; i++)
          clients[i] = new Integer( i*i + m );

      int k = 3;                                    // number of threads
      cashiers= new ServerThread[k];

      int p = m / k;                                // amount of workload

      for(int j=0; j < k; j++) {

         int start = j*p;
					// pass a reference to the JTextArea object
         cashiers[j] = new ServerThread( j+1, displayArea[j],
                                         start, start+p-1, clients, j+1 );
         cashiers[j].start();
      }
   }


   public static void main(String[] args) {

      // set up the GUI
      FastFoodServiceGUI gui = new FastFoodServiceGUI();

      // run the service threads
      gui.startService();

      gui.addWindowListener( new WindowAdapter() {
          public void windowClosing(WindowEvent e)
          { System.exit(0); }
      } );
   }
}

class ServerThread extends Thread {

    private int        idnum;      // thread number
    private JTextArea  jtext;      // GUI component

    private int from;
    private int to;
    private Object[] v;
    private int wait;

    ServerThread(int id, JTextArea jtext,
                 int a, int b, Object[] c, int d) {

       super( "Cashier Counter " + id );

       idnum = id;     this.jtext = jtext;
       from = a;       to = b;
       v = c;          wait = d;
    }

    public void run() {

       for (int i=from; i <= to; i++) {

/*
           System.out.println( getName() + ": serving customer " +
                               i + " <id = "+ (Integer)v[i] + ">" );
*/
           // process a customer's order
           jtext.append( "serving customer " + i + " id: " + (Integer)v[i] + "\n" );

	   try {
		switch( wait ) {
	      	   case 1: sleep(4500); break;
              	   case 2: sleep(2500); break;
              	   case 3: sleep(3500); break;
                }
	   }
	   catch( InterruptedException e) { }
       }

       // the thread will die after exiting the method run()
       jtext.append( "*** no more customers ***" );
    }
}