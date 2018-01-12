
// case 1: java ExceptionDemo
// case 2: java ExceptionDemo 10 20
// case 3: java ExceptionDemo 10 20 30 40

public class ExceptionDemo {

	public static void main( String[] args)
	{
		int num = 13, denom = 12, result;

	    int x[] = new int[5];


        result = args.length;

        System.out.println( "arg.length = " + result );

        try {
		      if (result == 0)

                  result = denom / result;

              else result = x[num] + 100;

              System.out.println( "- bye bye try!" );
	    }
	    catch( Exception error ) { System.out.println( error ); }

        String s = args[result-1];

        System.out.println( ".... the last token on the comamnd line: " + s );

		System.out.println( "... bye bye main!" );
	}
}