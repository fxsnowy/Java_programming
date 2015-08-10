package package2;


import package1.*;            //This is OK
//import package1.Example2;   //This is not OK for below code

import static package3.MyConstants.*; // imports all the static constants
                                      // only types can be imported. i.e.,
                                      // 'import static import static package3.*' is invalid syntax.
                                      // static syntax obfuscates code.
import static java.lang.Math.*;


class C3{
	Example1 var1;                   // OK fully qualified name refers to package1.Example
	// subpackage.Example var2;      // there is no package by name `subpackage`,
	                                 // there is a package called package1.subpackage
	                                 // Compiler error
	                                 // 'import package1.*' is not recursive. only imports classes from 'package1'
	package1.subpackage.Example var3;// OK
	Example2 var4;                   // refers to package2.Example2
	
}



public class Example2 {

	public static void main(String[] args) {
		
		double massDifference = massNeutron - massProton;
		// MyConstants var1; //did not import 'class MyConstants'
		
	}

}
