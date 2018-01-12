
// use of the ultimte super class in Java: Object
// generic/flexible programming

public class ObjectDemo {

   public static void main(String[] args) {

		Object[] one;  // reference to an array of ANY Java objects

    	// build an array of Double objects
    	one = new Double[3];

		one[0] = new Double(1.1);
		one[1] = new Double(3.3);
		one[2] = new Double(5.5);

    	show( one );

		// use the same object variable to build an array of Strings
    	one = new String[4];

		one[0] = new String( "http://xyz.com/abc/" );
		one[1] = new String( "http://tuv.com/pqr/" );
		one[2] = new String( "http://hik.com/def/" );

    	one[3] = "!#@##$%$%&^*(()_+=?><";

    	show( one );

        // use the same object variable to build an array of Employees
    	one = new Employee[2];

    	one[0] = new Employee( 11111, "John Doe", "70 The Pond", "1999" );
    	one[1] = new Employee( 22222, "Maria Gonzalez", "123 Steele", "2005" );

    	show(one);
   }

   // display an array of ANY Java objects

   public static void show( Object v[] ) {

   	  for ( int i=0; i < v.length; i++ )

            System.out.println( v[i] ); // polymorphism: v[i].toString()
   }
}