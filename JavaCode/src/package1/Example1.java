package package1;


/*
 * import declarations (not statements) are essentially short-hand enabler
 * at the source code level: it allows you to refer to a type or a static
 * member using a single identifier (e.g. List, min) as opposed to the
 * fully qualified name (e.g. java.util.List, Math.min).
 * 
 * import declaration section is a compile-time element of the source codes,
 * and has no presence at run-time. In JVM bytecodes, type names are always
 * fully qualified
 * 
 */

/*
 * Below declaration is called Import-on-demand(not sure).
 * All the import-on-demand statements are actually replaced with the class import.
 * For example, if the file is using 'List' and 'ArrayList', then the 
 * import java.util.* 
 *        will be replaced by
 * import java.util.List
 * import java.util.ArrayList
 *        after compilation.
 *        
 */
import java.applet.*;


/*
 * Here's how to deal with class conflicts:
 */
import java.sql.*; // has Date class
import java.util.*; // has Date class
import java.sql.Date; // Need sql's Date class


/*
 * Fully Qualified Names -VS- Canonical Name:
 * Both 'packages.Super.I' and 'packages.Sub.I' are fully qualified names that denote the
 * member class I, but only 'packages.Super.I' is its canonical name.
 * 
 */

class Super
{
	class I {} 
}

class Sub extends Super{
	
}

/*
 * class C1 has no more access to C2 of subpackage
 */

class C1{}



/*
 * 1) First line in source code specifies package.
 * 
 * 2) One class can refer to another (public)class in a different package
 * by using a fully qualified name. It is more common to use 'import' 
 * statements as this saves typing.
 * 
 * 3) import TypeName; where,  TypeName must be the canonical name of a 
 * class type, interface type, enum type, or annotation type.
 * 
 * 4) In a given package class/interface cannot have the same name.
 * 
 * 5) No class/interface can have the same name as a sub package in the given package.
 * 
 * 6) Every compilation unit(java package) automatically imports java.lang.*
 * 
 * 7) Windows doesn't make any distinction between Foo.class and foo.class but javac does.
 * 
 * 8) By default 'javac' puts class files into the same directory as the source file. For
 * large projects, you'll want to keep them separate, use the -d option to do this.
 * Example:
 *      myproject\source\com\ca\server
 *           Widget.java
 *      myproject\classes\com\ca\server (dir's within 'classes' will be created, if not exist)
 *           (Widget.class goes here)
 * 
 *      cd myproject\source
 *      javac -d ..\classes com\ca\server\Widget.java
 * IDE's take care of this stuff in the back ground.
 * 
 * 
 *      
 */
public class Example1 {

	public static void main(String[] args) {
		
		
	}

}