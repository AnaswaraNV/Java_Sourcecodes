
class StringBufferDemo{

   public static void main( String args[] ){
   
       StringBuffer sb = new StringBuffer( "JAV745" );
	   
	   System.out.println( sb + " has " + sb.length() + " characters." );
	   
	   sb.append( '-' ); // append a character
	   sb.append( "Java" );
	   sb.append( ' ' );
	   sb.append( "Programming in the DAD program" );
	   sb.append( '.' );
	   
	   System.out.println( sb );
	   
	   sb.insert( 7, "I love "  ); // index: 7
	   System.out.println( sb );
	   
	   sb.delete( 0, 7 ); // starting index: 0, ending index: 7-1 (7: number of characters)
	   System.out.println( sb );
	   
	   sb.reverse();
	   System.out.println( sb );
   }
}