
public class StringDemo2 {

   public static void main(String[] args) {

	String s1 = new String( "Albert Einstein is learning Java" );

	char c = s1.charAt(7);

	System.out.println( s1 );
	System.out.println( "length of the string: " + s1.length() );
	System.out.println( "character at index 7: " + c );

	char charArray[] = s1.toCharArray();

	System.out.println( "size of charArray: " + charArray.length );

	for(int i=0; i < charArray.length; i++)
	   System.out.println( charArray[i] );

	// API specification: getChars, concat, toLowerCase

    // compare the CONTENTS of two String objects!!!
	String s2 = "Albert Einstein is learning Java";

    if (s1 == s2)

             System.out.println( "s1, s2: same addresses" );
        else System.out.println( "s1, s2: addresses are not the same!" );

	if ( s1.equals( s2 ) )

           System.out.println( "both strings have the same contents" );





   }
}
