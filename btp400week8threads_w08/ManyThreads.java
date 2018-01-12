
// source of inspiration: Morelli

public class ManyThreads {

   public static void main( String args[] ) {

      SingleThread st1, st2, st3, st4, st5;

      st1 = new SingleThread( '+' );
      st2 = new SingleThread( 'x' );
      st3 = new SingleThread( 'e' );
      st4 = new SingleThread( 'Q' );
      st5 = new SingleThread( '.' );

      st1.start();
      st2.start();
      st3.start();
      st4.start();
      st5.start();
   }
}

class SingleThread extends Thread {

    private char c;

    public SingleThread( char c ) { this.c = c; }

    public void run() {

       for (int i=0; i < 200; i++)
           System.out.print( c );
    }
}