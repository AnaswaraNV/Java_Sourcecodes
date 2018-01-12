// How to implement the idea of a 2-dimensional array in Java?
// Java: an array of arrays
// Note: an array is an object in Java

public class ArrayDemo2 {

   public static void main(String[] arg) {

        double account[][] = new double[3][3];

	for (int k=0; k < account.length; k++) {
         
            for (int m=0; m < account[k].length; m++)
                System.out.print( account[k][m] + " " );   // default values
	 
            System.out.println();
        }

	// Part 2: an unbalanced/irregular array
	double account2[][] = new double[3][];        // account2: 3 rows of array objects
						      // account2[0]: 1st row
						      // account2[1]: 2nd row
						      // account2[2]: 3rd row
        account2[0] = new double [2];

        account2[1] = new double [3];

        account2[2] = new double [1];

	System.out.println( "number of rows: " + account2.length );

        build( account2 );
        show( account2 );    
   }

   private static void build( double a[][] ) {

	for (int i=0; i < a.length; i++)
	    for (int j=0; j < a[i].length; j++)
		a[i][j] = i+j+0.5;
   }

   private static void show( double b[][] ) {

 	for (int i=0; i < b.length; i++) {

            System.out.println( "size of of row " + i + ": " +
                                b[i].length );

            for (int j=0; j < b[i].length; j++ )
		System.out.print( b[i][j] + " " );                

            System.out.println();
	}	
   }
}

/* compile-time array:
   double account[][] = { {0.1, 0.2}, {0.3, 0.4, 0.5}, {0.6} };

 */
