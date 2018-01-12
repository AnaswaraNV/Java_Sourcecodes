
// 1. literal strings
// 2. immutable objects

public class StringDemo {

   public static void main(String[] args) {

    // String literals are stored as String objects in the memory
    // special case: 3 occurrences of one String literal in the code are reference to ONE String object

    String a = "Seneca@York", b = "Seneca@York", c = "Seneca@York";

    System.out.println( a + "\n" + b + "\n" + c );

    if ( a == c )
         System.out.println( "... special case: a and c reference the SAME String object in the memory" );

    if ( a.equals(b) )
         System.out.println( "... both String objects have the SAME CHARACTER CONTENTS" );

    // Part 2
	String s1 = new String( "Seneca@York" );  // another String object is created;
											  // it references the String literal "Seneca@York

    if ( a == s1 )
         System.out.println( "a and s1 REFERENCE the same String object" );
    else System.out.println( "a and s1 do NOT reference the same String object" );

    if ( a.equals(s1) )
         System.out.println( "... both String objects have the SAME character CONTENTS" );

    // Part 3
	String s2 = new String( "Albert Einstein" );


	char charSet[] = { 'A', 'l', 'b', 'e', 'r', 't', ' ', 'E', 'i', 'n', 's', 't', 'e', 'i', 'n' };

	String s3 = new String( charSet );

	System.out.println( s2 + "\n" + s3 );

	System.out.println( "s2 == s3: " + (s2 == s3) +
	                    "\ns2.equals(s3): " + s2.equals(s3) );

	System.out.println( "string length information:" );
	System.out.println( "length of s2: " + s2.length() + "\n" +
	                    "length of s3: " + s3.length() );

	// Part 4
	String empty = "";

    System.out.println( "length of an empty string: " + empty.length() );
    System.out.println( "Can we see it? <" + empty + ">" );

	System.out.println( "***************\n" );


	// two reference type variables
	s1 = s2 = s3;

	System.out.println( "s1, s2, s3:" );
	System.out.println( s1 + "\n" + s2 + "\n" + s3 );

    // a String object is IMMUTABLE (i.e. the character contents of a String object cannot be changed)
    // what is going to happen here?

    s3 = s3 + ">> Mocha?";

    System.out.println( "\ns3 is changed; how about s1, s2?" );
    System.out.println( s1 + "\n" + s2 + "\n" + s3 );
   }
}