// one try block
// multiple catch blocks
// only one catch block will be used!

// command lines: java TryCatchDemo2
//                java TryCatchDemo2 34
//                java TryCatchDemo2 hi there
//                java TryCatchDemo2 hello

public class TryCatchDemo2{

	public static void main( String[] args )
	{
		int   num = 13, denom = 0, result= -999;
		int[] array = { 22,33,44 };

		try {
			 result = num / args.length;

			 if ( args.length == 2)

			      result = array[ num ];

			 result = Integer.parseInt( args[0] );
		}

		catch( ArithmeticException error ){

			System.out.println( "Arithmetic Error" );
			result = 111;
		}

		catch( IndexOutOfBoundsException error ){

			System.out.println( "Array Index Error" );
			result = 222;
		}

        catch( Exception error ) {

			System.out.println( error );
			result = 333;
		}

		System.out.println( "result: " + result );
		System.out.println( "... main: bye bye" );
	}
}