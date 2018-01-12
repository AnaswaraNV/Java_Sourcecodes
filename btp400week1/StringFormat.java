class StringFormat {

    public static void main( String args [] ){
	
	    String s = String.format( "%7.2f%7d%-12s", 
		                          78.567, 77, "Hello" );
								  
		System.out.println( s );
		
		// printf
		System.out.printf( "...\n%7.2f%7d%-12s\n",
		                   78.567, 77, "Hello" );
						   
		// print
		System.out.print( String.format( "%7.2f%7d%12s\n", 
		                                 78.567, 77, "Hello" ) );
	}
}