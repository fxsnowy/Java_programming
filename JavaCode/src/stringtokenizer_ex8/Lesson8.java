package stringtokenizer_ex8;
import java.util.StringTokenizer;

public class Lesson8 {
	/*
	 * JDK doc stated that "StringTokenizer" is a legacy class.
	 * It is recommended that anyone seeking this functionality use the split() method
	 * of String or java.util.regex package instead.
	 */
	public static void main(String[] args) {
		String str = "Monday Tuesday Wednesday Thursday Friday Saturday Sunday";
		String strReverse;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(str); //Constructs a StringTokenizer for the given string,
		// using the default delimiter set of " \t\n\r\f" (i.e., blank tab newline carriage-return form-feed)
		// Delimiter characters themselves will not be treated as tokens.
		
		
		while(st.hasMoreTokens()){
			sb.insert(0, st.nextToken());
			if(st.hasMoreTokens()){
				sb.insert(0, " ");
			}
		}
		
		
		strReverse = sb.toString();
		System.out.println(strReverse);
	}

}
