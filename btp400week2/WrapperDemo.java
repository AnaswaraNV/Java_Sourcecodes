
// a demo on wrapper classes
// e.g. Integer, Double, Character

public class WrapperDemo {

   public static void main(String[] args) {

    // primitive data types
	int    m = 77;
    double x = 3.4546789;

	System.out.println( "m: " + m );
    System.out.println( "x: " + x );

	// wrapper class: Integer
    Integer a = new Integer( m );

	System.out.println( "string representation of a: " + a );
	System.out.println( "use of toString(): " + a.toString() );

	int k = a.intValue() * -1;      // getter

	System.out.println( "k: " + k );

	System.out.println( " static method call: " +

			             Integer.valueOf( "97865" ) );  // an Integer object is returned

	// wrapper class: Double
    Double  b = new Double( x );

	System.out.println( "string representation of b: " + b );
	System.out.println( "use of toString(): " + b.toString() );

	double z = b.doubleValue();     // getter

	z++;

	System.out.println( "z: " + z );

	System.out.println( " static method call: " +

			            b.valueOf( "-9.876543" ) );  // a Double object is returned

    // useful static methods: parseInt, parseDouble, toLowerCase
    // a collection of wrapper objects (e.g. an ArrayList of Integers)

   }
}