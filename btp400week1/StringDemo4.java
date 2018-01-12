
// a demo on using the StringBuffer class

// Problem: Convert the case of the substring: "cplusplus"


public class StringDemo4 {

   public static void main(String [] args) {

      String s1  = "java 2 for cplusplus programmers";
      String sub = "cplusplus";

      StringBuffer b = new StringBuffer( s1 );

      System.out.println( "b :" + b );		// StringBuffer

      // manipulation
      int start = s1.indexOf( sub );

      for (int i=0; i < sub.length(); i++) {

          char c = b.charAt( start+i );

          b.setCharAt( start+i, Character.toUpperCase( c ) );
      }

      System.out.println( "b :" + b );

      s1 = b.toString();
      System.out.println( "s1:" + s1 );

      // Part 2
      System.out.println( "\n##########################" );

      b.setLength(12);
      System.out.println( b + "<<<" );
      System.out.println( "length of the string: " + b.toString().length() + "\n" );

      b.setLength(20);
      System.out.println( b + "<<<" );
      System.out.println( "length of the string: " + b.toString().length() );

      /* the unicode characters in Java */
      char unicodetest[] = { '\u0041', '\u0061', '\u0000' }; // 'A', 'a', the null character in Java

      for (int j=0; j<unicodetest.length; j++)

           System.out.print( unicodetest[j] + "..." );

   }
}