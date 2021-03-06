package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


/*
 * To re-create the object from the persistent file, you would employ below code
 */

public class JavaDeSerialization  {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("temp.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		TestSerial ts = (TestSerial) oin.readObject();
		System.out.println("version="+ts.version);

	}
}

/*
 * In the above code, the object's restoration occurs with the
 * 'oin.readObject()' method call. This method call reads in the
 * raw bytes that we previously persisted and creates a live object.
 * 
 * 
 */ 
