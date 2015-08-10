package Exceptions;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Dell
 *
 */
public class MyException extends RuntimeException {

	public MyException(String string, SQLException sqlException) {
		
	}

	public MyException(IOException processException, IOException e,
			String string) {
		// TODO Auto-generated constructor stub
	}

	public MyException(IOException e, String string) {
		// TODO Auto-generated constructor stub
	}

}
