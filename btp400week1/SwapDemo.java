// A demo on pass-by-value in Java

public class SwapDemo {

	private int  m;
	private char c;

	// no constructors!

	static void swap(int x, int y) {

	    int t;

	    t = x;   x = y;   y = t;
    }


	public static void main(String[] args) {

		int first = -500, second = 700;

		System.out.println( "first: " + first +
				            " second: " + second );

		swap(first, second);

		System.out.println( "after swap: " + first + "," +
						     second );


	}
}