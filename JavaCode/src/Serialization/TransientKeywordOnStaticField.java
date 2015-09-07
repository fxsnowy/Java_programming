package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 'Foo' contains a pair of class fields, 'w' and 'x', as 
 * well as instance fields, 'y' and 'z'.
 * 
 * You should observe the following output:
 * 
 *       w: 1
 *       x: 2
 *       y: 3
 *       z: 4
 *       
 *       w: 1
 *       x: 2
 *       y: 3
 *       z: 0
 *       
 * This output tells us that instance field 'y' was serialized but not z, 
 * which was marked transient. However, it doesn't tell us whether class 
 * fields 'w' and 'x' were serialized and then deserialized, or simply 
 * initialized in the normal class-initialization manner when the 
 * serialized 'Foo' object was deserialized.
 * 
 * we need to investigate `x.ser`'s contents:
 * 
 * A hexadecimal dump of `x.ser` provides the following output:
 * 
 * 00000000 AC ED 00 05 73 72 00 03 46 6F 6F FC 7A 5D 82 1D ....sr..Foo.z]..
 * 00000010 D2 9D 3F 02 00 01 49 00 01 79 78 70 00 00 00 03 ..?...I..yxp....
 * 
 *
 */

class Foo implements Serializable {
	public static int w = 1;
	public static transient int x = 2;
	public int y = 3;
	public transient int z = 4;
}

public class TransientKeywordOnStaticField {

	public static void main(String[] args) throws IOException{
		Foo foo = new Foo();
		System.out.printf("w: %d%n", Foo.w);
		System.out.printf("x: %d%n", Foo.x);
		System.out.printf("y: %d%n", foo.y);
		System.out.printf("z: %d%n", foo.z);
		try (FileOutputStream fos = new FileOutputStream("x.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(foo);
		}

		foo = null;

		try (FileInputStream fis = new FileInputStream("x.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			System.out.println();
			foo = (Foo) ois.readObject();
			System.out.printf("w: %d%n", Foo.w);
			System.out.printf("x: %d%n", Foo.x);
			System.out.printf("y: %d%n", foo.y);
			System.out.printf("z: %d%n", foo.z);
		} catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe.getMessage());
		}

	}

}
