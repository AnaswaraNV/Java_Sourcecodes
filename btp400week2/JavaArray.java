
// a Java array of integers

public class JavaArray {

	public static void main( String args[] ) {

		int marks [];  // declare an array

		marks = new int [10]; // create an array object

		for (int j=0; j < marks.length; j++)
		     System.out.print( marks[j] + " " );

        System.out.println();

		for (int i=0; i < marks.length; i++)

				marks[i] = i * 3;

		for (int k=marks.length; k>0; k--)

				System.out.println( marks[ k - 1 ] );

		// what if marks[k] is used instead?


	}
}