// Arrays are objects in Java

public class ArrayDemo {

   public static void main(String[] args) {

	int a[];      // a is NOT initialized
   
	/* compiler error:
           if ( a == null) System.out.println( "a is null" );
         */
     
	a = new int [3];  // create an array object!

	System.out.println( "size of a: " + a.length );
        
	System.out.println( "default values of the array elements:" );
        for ( int i=0; i < a.length; i++ ) 
            System.out.println( a[i] + " " );

	a[2] = -2;
	a[1] = -4;
	a[0] = -6;

	int b[] = { 1, 3, 5, 7, 9, 11 }; // create and initialize an array
	
	System.out.println( "size of b: " + b.length );

	display( 'a', a );
	display( 'b', b );


	// Part 2: two reference type variables
	a = b;

	display( 'a', a );
        
        System.out.println( "modifying array b..." );
        b[2] = -111;

        display( 'b', b );
        display( 'a', a );

	// Part 3: arraycopy
        System.out.println( "copying the contents of an array..." );

	int c[] = { -2, -4, -6, -8 };

	display( 'c', c );

	System.arraycopy(a, 1, c, 2, 2 ); // static method
					  // source index:1, destination index:2
                                          // number of elements:2

	display( 'c', c);

	// c[4] = 999;		// runtime error: ArrayIndexOutOfBoundException
	
   } 
   
   static void display( char c, int z[] ) {

	for(int i=0; i < z.length; i++) {
	
	   if (i==0) System.out.print( c + ": ");

	   System.out.print( z[i] + " " );
	}
	System.out.println();
   }   

}