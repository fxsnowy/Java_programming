package Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Tpc3_CatchingMultipleExceptions {

	public static void main(String[] args) {
		/*
		 * 1) Before Java 7 you would write something like this:
		 *
		 * 2) As you can see, the two exceptions SQLException and IOException
		 * are handled in the same way, but you still have to write two
		 * individual catch blocks for them.
		 * 
		 */
		try {

		    // execute code that may throw 1 of the 3 exceptions below.
			
			byte a = 2, b = 3;
			if (a > 2) {
				throw new SQLException();
			} else if (b > 0) {
				throw new IOException();
			}			

		} catch(SQLException e) {
		    //logger.log(e);

		} catch(IOException e) {
		    //logger.log(e);

		} catch(Exception e) {
		    //logger.severe(e);
		}
		
		/*
		 * In Java 7 you can catch multiple exceptions using the multi catch syntax
		 * 
		 */
		
		try {

		    // execute code that may throw 1 of the 3 exceptions below.
			if (true){
				throw new SQLException();
			} else{
				throw new IOException();
			}
		}catch(SQLException | IOException e) {
		    //logger.log(e);

		} catch(Exception e) {
		    //logger.severe(e);
		}
		

	}

}
