package stringsplit_ex9;

public class Lesson9 {

	public static void main(String[] args) {
		String str = "Monday Tuesday Wednesday Thrusday Friday Saturday Sunday";
		String [] tokens = str.split("\\s"); // white space '\s' is a delimiter
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < tokens.length; i++){
			sb.insert(0, tokens[i]);
			if(i < tokens.length - 1){
				sb.insert(0, " ");
			}
		}
		
		String strReverse = sb.toString();
		System.out.println(strReverse);

	}

}
