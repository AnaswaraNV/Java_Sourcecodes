
public class StringDemo3 {

   public static void main(String [] args) {

      String s1 = "   Java 2 for C++ Programmers  ";

      String word1, word2;

      System.out.println( "s1:" + s1 + ":" + s1.length() );

      s1 = s1.trim();

      System.out.println( "s1:" + s1 + ":" + s1.length() );

      // Part 2
      word1 = s1.substring(0, 6);  // indices: 0, 6-1

      word2 = s1.substring(6);

      System.out.println( "word1:<" + word1 + ">\nword2:<" + word2 + ">" );

      int start = s1.indexOf( "C++" );

      int end   = s1.indexOf( "ram", 10 );  // case sensitive

      word2 = s1.substring( start, end );

      System.out.println( word2 );

   }
}