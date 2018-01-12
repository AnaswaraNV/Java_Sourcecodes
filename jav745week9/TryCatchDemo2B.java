
// one try block
// and multiple catch blocks
// only one catch block will be used! 

// compile-time error: unreachable catch blocks!!!

public class TryCatchDemo2B{

	public static void main( String[] args )
	{
		int num = 13, denom = 0, result;
		int[] array = { 22,33,44 };

		try {
			result = num * num;
			result = array[ num ];
			result = num / denom;	
		}

		catch(Exception error) {
			System.out.println( "Error: " +
					    error.getMessage() );
			result = -7;
		}

		catch(ArithmeticException error){
			System.out.println( "Arithmetic Error" );
			result = 222;
		}
	
		catch(IndexOutOfBoundsException error){
			System.out.println( "Array Index Error" );
			result = 111;
		}

		
		System.out.println( "result: " + result );
		System.out.println( "Bye bye: only one exception is thrown!" );
	}
}