package sourcecodeformat_ex2;

public class Lesson2 {

	public static void main(String[] args) {
		
		// Programs can be written in UTF-16 
		//With unicode escapes all programs can be written using only ASCII
		//The first thing the compiler does is replace Unicode escape sequences.
		char ch1 = '\u00A5';
		char ch2 = '\uuuuuuu00A5';
		\u0063\u0068\u0061\u0072 ch3 = \u0027\u005C\u005C\u0027;
		String ch4 = "\uD800\uDC00";
		String str1 = "\\\\\uuuuuuuu0063";
		int \u00A5 = 200;
		String str = "\u0043\u0044";
		double d = 0\u00580\u007010\u0044;
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4); //non - BMP character
		System.out.println(str1);
		System.out.println(\u00A5);
		System.out.println(str);
		System.out.println(d);
	}
}