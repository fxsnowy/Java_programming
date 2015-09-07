package Serialization;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 1) The 'transient' keyword prevents the values of instance fields 
 * that are declared with this keyword from being persisted when an 
 * object is serialized (written as a sequence of bytes to some 
 * destination). The values of such instance fields shouldn't be 
 * persisted and later restored when an object is deserialized 
 * (reconstituted from a sequence of bytes read from some source).
 * 
 * 2) For example, if your object has a field of type java.io.InputStream,
 * you don't serialize this field's reference because the stream won't be
 * open for input when you deserialize the object -- the stream source
 * (e.g., a file) might not exist.
 * 
 * How do I use transient?
 *
 * Include the transient modifier in the instance field's declaration. 
 * Below code presents a small demonstration.
 * 
 * 'TransientKeywordDemo' is an application class that serializes and 
 * deserializes a 'ClassLib' instance.
 * 
 * 'ClassLib' declares its 'is' instance field transient because it makes 
 * no sense to serialize an input stream (as previously explained). In fact,
 * if this field wasn't transient, a 'java.io.NotSerializableException' 
 * would be thrown when deserializing `x.ser`'s contents because InputStream
 * doesn't implement the Serializable interface.
 * 
 * Compile below code:
 *          javac TransientKeywordDemo.java
 * 
 * Run this application with TransientKeywordDemo.class as its single argument: 
 *          java TransDemo TransDemo.class
 * 
 * Output shows:
 *    ClassLib(InputStream) called
 *    Minor version number: 0
 *    Major version number: 51
 *    java.io.FileInputStream@79f1e0e0
 *    
 *    Minor version number: 0
 *    Major version number: 51
 *    null
 *
 * The above shows that no constructor is invoked when the object is reconstituted.
 *  
 */

public class TransientKeywordDemo {

	public static void main(String[] args) throws IOException{
		if (args.length != 1) {
			System.err.println("usage: java TransientKeywordDemo classfile");
			return;
		}
		ClassLib cl = new ClassLib(new FileInputStream(args[0]));
		System.out.printf("Minor version number: %d%n", cl.getMinorVer());
		System.out.printf("Major version number: %d%n", cl.getMajorVer());
		cl.showIS();

		try (FileOutputStream fos = new FileOutputStream("x.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(cl);
		}

		cl = null;

		try (FileInputStream fis = new FileInputStream("x.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			System.out.println();
			cl = (ClassLib) ois.readObject();
			System.out.printf("Minor version number: %d%n", cl.getMinorVer());
			System.out.printf("Major version number: %d%n", cl.getMajorVer());
			cl.showIS();
		} catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe.getMessage());
		}
	}
}
