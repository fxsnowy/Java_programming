package StaticMemberClasses;

/*
 * An interface is a static interface, when declared as a member of
 * a top level class.
 * 
 * An interface within a class is package-private, by default.
 * 
 * All accessibility modifiers are available to the static member interface.
 * 
 */

interface I{
	void f();
}

class Foo {
	interface Bar { 
        void callback();
    }
    public static void registerCallback(Bar bar) { }
    public static void registerCallback1(I i){ }
}


public class NestedInterfaceInClass {
	public static void main(String[] args) {
		
		Foo.registerCallback1(new I(){
			public void f(){
				
			}
		});
		
		Foo.registerCallback(new Foo.Bar() {
		    public void callback() { }
		});
		
	}
}