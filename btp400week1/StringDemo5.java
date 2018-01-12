
// the split method and regular expressions

// (StringTokenizer: a legacy class)

public class StringDemo5 {

   public static void main(String [] args) {

      String s[]  = { "java 2 for cplusplus programmers",

      						"JAVA,2, FOR           CPLUSPLUS,     PROGRAMMERS" };

      String [] regexp = { "\\s", "\\s+|,\\s*" }; //regular expressions that define the delimeters

      String [] tokens;

      for (int j=0; j < s.length; j++) {

		    tokens = s[j].split( regexp[j] );

            System.out.println( "\n" + s[j] + "\n" );

            for (int i=0; i < tokens.length; i++)

                 System.out.println( i + ":" + tokens[i] );

      }
   } // main
}