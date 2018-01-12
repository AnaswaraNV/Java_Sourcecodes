
public class References {

    public static void main(String args[]) {

	    Employee a = new Employee( 1111, "John Ash",
					                     "45 Owl Street", "1950" ),

                 b = new Employee( 2222, "Mary Stacey",
                                         "99 Queen Ave.", "1988" );

        System.out.println( a + "\n" + b );

        a = b;

        a.setAddress( "TERRIBLE!" );

        System.out.println( a );
        System.out.println( b );

        System.out.println( "Where is John Ash?" );


    }
}