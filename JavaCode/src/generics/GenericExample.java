package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1) Wildcard ? adds more restriction in generics.
 * 
 * 2) For syntax, '? extends Number',  'Number' is is upper bound.
 * 
 * 3) For syntax, '? super Number', 'Number' is lower bound.
 * 
 * 4) For syntax, 'void print(List<? super Integer> list)', a method
 *  that takes a List of type 'Integer' or it's super class
 * 
 * 3) Wildcards support both upper and lower bounds, type parameters
 * just support upper bounds. So, if you want to define a method
 * that takes a List of type Integer or it's super class, you can do:
 * 
 *       public void print(List<? super Integer> list)  // OK
 *       
 *but you can't use type parameter:
 *
 *       public <T super Integer> void print(List<T> list)  // Won't compile
 *       
 *
 * 4) If you have only one parameterized type argument, then you can
 * use wildcard, although type parameter will also work.
 * 
 */

public class GenericExample {

	public void betterForCasting(){
		List<String> lst = new ArrayList<>();
		lst.add("a string");
		lst.add("Another string");
		
		/*
		 * After each get(), 'checkcast' byte code instruction is immediately added
		 *  that casts right hand side of the expression to 'String' type.
		 * 
		 */
		String s = lst.get(0);
		String s2 = lst.get(1);
	}
	
	public void boxesTest(){
		List<Box> boxesRaw = new ArrayList<>();
		
		Box box1 = new Box();
		box1.setObj("a String");
		
		Box box2 = new Box();
		box2.setObj("a String");
		
		boxesRaw.add(box1);
		boxesRaw.add(box2);
		
		/*
		 * After get(), 'checkcast' byte code instruction is immediately added
		 *  that casts right hand side of the expression to 'Box<Object>' type.
		 * 
		 */
		box1 = boxesRaw.get(0);   
		
		List<Box<String>> boxesWithGeneric = new ArrayList<>();
		
		Box<String> box3 = new Box();
		box3.setObj("a String");
		
		Box<String> box4 = new Box();
		box4.setObj("a String");
		
		boxesWithGeneric.add(box3);
		boxesWithGeneric.add(box4);
		
		/*
		 * After get(), 'checkcast' byte code instruction is immediately added
		 *  that casts right hand side of the expression to 'Box<String>' type.
		 * 
		 */
		box3 = boxesWithGeneric.get(0); 
		
		box1.inspect(123);
		box1.inspect(123.0);
		//box1.inspect("a string"); //compile time check error
	}
	
	public void usingPairs(){
		Pair<String, String> p =  new OrderedPair<>("aKey", "aValue");
		
		
	}
	
	/*
	 * Below method can print a list of Object instances.
	 * 
	 * It cannot print List<Integer>, List<String>, List<Double>
	 */
	public static void printList(List<Object> list){
		for(Object element: list){
			System.out.println(element);
		}
	}
	
	/*
	 * Below method can print a list of Object instances.
	 * 
	 * It can also  print List<Integer>, List<String>, List<Double>
	 */
	public static void printList1(List<?> list){
		for(Object element: list){
			System.out.println(element);
		}
	}
	
	public void showSumOfNumbers(){
		sumOfNumbers(Arrays.asList(1, 2, 3)); //asList provide List<integer>
	}
	
	
	public void sumOfNumbers(List<? extends Number> numbers){
		double d = 0.0;
		for(Number n: numbers){
			d += n.doubleValue();
		}
		System.out.println(d);
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
