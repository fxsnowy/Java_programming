package PublicMethInDefauClass.two;
import PublicMethInDefauClass.one.*;

/*
 * This is how public method 'm1' from default class of another package
 * is bypassed.
 * 
 */
public class C {

	public static void main(String[] args) {
		A a = A.makeB();
		a.m1();
	}

}
