package Serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;


/*
 * 'ClassLib' is the skeletal beginnings of a library for reading 
 * Java class files, and implements the 'java.io.Serializable' interface
 * so that its instances can be serialized and deserialized.
 * 
 */
public class ClassLib implements Serializable{
	private transient InputStream is;

	private int majorVer;
	private int minorVer;

	ClassLib(InputStream is) throws IOException {
		System.out.println("ClassLib(InputStream) called");
		this.is = is;
		DataInputStream dis;
		if (is instanceof DataInputStream)
			dis = (DataInputStream) is;
		else
			dis = new DataInputStream(is);
		if (dis.readInt() != 0xcafebabe)
			throw new IOException("not a .class file");
		minorVer = dis.readShort();
		majorVer = dis.readShort();
	}

	int getMajorVer() {
		return majorVer;
	}

	int getMinorVer() {
		return minorVer;
	}

	void showIS() {
		System.out.println(is);
	}
}