package StaticMemberClasses;

/*
 * If a field in an enclosing class has the same name as an inherited 
 * field the inherited field shadows the field in the enclosed class.
 * By default the inherited field will be used. The same applies to two
 * override equivalent methods.
 * 
 */

class Ext{
	static int i = 99;
	static String n() { return "In Ext"; }
	
}

class Sub{
	static int i = 88;
	static String n() { return "In Outer"; }
	static class Inner extends Ext{
		static void m(){
			System.out.println(i + n()); // prints out: 99 In ext
		}
	}
}

public class HidingFieldsAndMethods {
	public static void main(String[] args){
		Sub.Inner.m();
		System.out.println(Sub.Inner.n()); // prints: In Ext
	}
}