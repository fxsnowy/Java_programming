package generics;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 1) Java generics syntax enables the compiler to explicitly add the cast 
 * to the byte-code for you i.e., 'checkcast' byte code instruction, and
 * compiler makes sure that this cast has no way to fail.
 *  
 * 2) Generics in Java are a compile-time only phenomenon.
 * 
 * 3) In the byte-code, all references to T in the GenericType class below are replaced by 'Object'.
 * This process is referred to as "type erasure".
 * 
 * Javadoc says:
 *     a)  Replace all type parameters in generic types with their bounds or Object
 *    if the type parameters are unbounded. The produced bytecode, therefore, contains
 *    only ordinary classes, interfaces, and methods.
 *    b) Insert type casts if necessary to preserve type safety.
 *    
 * 4)  It is important to remember that type safety in Java is provided by the compiler only.
 * If your program compiles without any errors AND without any warnings, then your program,
 * generics and all, is type safe.
 * 
 * 5) The compiled program, however, has retained almost no information about the generic
 * parameters. 
 *  
 */


public class GenericType<T> {
	private String test = "Hello";

    public T get() {
        return (T) test;
    }

    public static void main(String[] args) {
        System.err.println("Test 1");
        GenericType<Integer> g1 = new GenericType<>();
        Object o1 = g1.get();

        System.err.println("Test 2");
        GenericType<Integer> g2 = new GenericType<>();
        Integer o2 = g2.get(); //java.lang.ClassCastException
    }

}