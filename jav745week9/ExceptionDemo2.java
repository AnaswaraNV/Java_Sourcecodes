
public class ExceptionDemo2 {

	public static void main( String[] args)
	{
		int num = 13, denom = 12, result;

		try {
				double x[] = new double[5];

				x[num] += 100;
		}
		catch (ArrayIndexOutOfBoundsException e) {

   			System.out.println( e );
   			System.out.println( e.getMessage() );
		}

		System.out.println( "Bye bye!" );
	}
}