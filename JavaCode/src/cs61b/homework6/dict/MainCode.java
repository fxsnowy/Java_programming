package cs61b.homework6.dict;

class Word{
	public static final int LETTERS = 26, WORDS = LETTERS*LETTERS;
	private String word;

	public Word(String str){
		this.word = str;
	}
	@Override
	public int hashCode(){
		return LETTERS * (word.charAt(0) - 'a') + (word.charAt(1) - 'a');
	}
	
	public String getWord(){
		return this.word;
	}
}

class Definition{
	private String meaning;
	public Definition(String str){
		this.meaning = str;
	}
	
	public String getMeaning(){
		return this.meaning;
	}
}

public class MainCode {

	public static void main(String[] args) {
		Dictionary dict = new HashTableChained();
		Word word = new Word("aa");
		Definition def = new Definition("basaltic lava forming very rough, jagged masses with a light frothy texture.");
		dict.insert(word, def);

	}

}
