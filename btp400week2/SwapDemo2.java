// A demo on pass-by-value in Java

public class SwapDemo2 {

	private int  m;
	private char c;

	public SwapDemo2() { this( 0, '?'); }

	public SwapDemo2(int k, char z) { m=k; c=z; }

	public int getM() { return m; }

	public char getC() { return c; }

	public void setM( int z ) { m = z; }

	public void setC( char x ) { c = x; }

	public String toString() { return "m: " + m + " c: " + c; }

	public static void swap( SwapDemo2 a, SwapDemo2 b ) {

	     SwapDemo2 t;

	     t = a;   a = b;   b = t;
	}

    public static void swapSwap( SwapDemo2 w, SwapDemo2 v ) {

	     int  t1;
	     char t2;

	     t1  = w.getM();		t2 = w.getC();

         w.setM( v.getM() );    w.setC( v.getC() );

         v.setM( t1 );			v.setC( t2 );
    }

	public static void main(String[] args) {


		SwapDemo2 one, two; 	// declare two objects

		one = new SwapDemo2( 1, 'A' );
		two = new SwapDemo2( 2, 'z' );

		System.out.println( one );
 		System.out.println( two );
        System.out.println( "swap..." );

		swap( one, two );

		System.out.println( one );
		System.out.println( two );

        swapSwap( one, two );
        System.out.println( "another swap\n" + one + "\n" + two );


	}
}