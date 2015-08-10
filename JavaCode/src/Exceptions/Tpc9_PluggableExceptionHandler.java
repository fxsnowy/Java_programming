package Exceptions;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * Pluggable exception handlers is a technique that allows the 
 * users of a component to customize the exception handling of 
 * that component. Instead of handling, enriching, wrapping and/or
 * logging the exception, the exception handling is delegated to
 * an exception handler. Here is how an exception handler interface
 * could look in code.
 * 
 */

interface ExceptionHandler {
    public void handle(Exception e, String errorMessage);
}

/*
 * And here is a class that uses this above interface
 */
class Component{
    protected ExceptionHandler exceptionHandler = null;

    public void setExceptionHandler(ExceptionHandler handler){
        this.exceptionHandler = handler;
    }
    
    /*
     * Notice how the catch clause in the processFile method does 
     * not wrap, rethrow or log caught IOException's. The exceptions
     * are passed to the ExceptionHandler instance's handle() method.
     * The exception handler can then decide what to do with it.
     * Should the exception be ignored? Logged? Wrapped in a different
     * exception? Or just rethrown as it is? The exception handler
     * can decide for itself. Note however, that the exception handler
     * cannot throw checked exceptions that were not declared in the
     * method where the exception was caught. For instance, the
     * processFile method does not declare any checked exceptions.
     * Thus, the ExceptionHandler's handle() method cannot throw any 
     * checked exceptions. However, the ExceptionHandler can throw all
     * the unchecked exceptions it wants (RuntimeException and subclasses of it).
     * 
     */
    public void processFile(String fileName){
        FileInputStream input = null;
        try{
            input = new FileInputStream(fileName);
            processStream(input);
        } catch (IOException e){
            this.exceptionHandler.handle(e,
                "error processing file: " + fileName);
        }
    }

    protected void processStream(InputStream input)
        throws IOException{
        //do something with the stream.
    }
}


/*
 * Where to use Pluggable Exception Handlers?
 * 
 * Pluggable exception handlers are most effective in situations 
 * where the exceptions occurring can be handled sensibly in 
 * different ways. For instance, when validating an XML document,
 * or an HTML form, you may not always want to stop the validation
 * at the first validation error. In some situations you might want 
 * to continue validation to catch all validation exceptions thrown,
 * and show them all to the user at the same time. This saves the
 * user from having to correct an error, validate, correct error, 
 * validate over and over again. All errors can be caught and 
 * corrected in one iteration.
 * 
 */
class MyHandler implements ExceptionHandler{
    public void handle(Exception e, String message) {
    	//do nothing, just ignore the exception
    }
}

class WrappingHandler implements ExceptionHandler{
    public void handle(Exception e, String message){
        throw new RuntimeException(message, e);
    }
}

class CollectingHandler implements ExceptionHandler{
    List exceptions = new ArrayList();

    public List getExceptions(){ return this.exceptions; }

    public void handle(Exception e, String message){
        this.exceptions.add(e);

        //message is ignored here, but could have been
        //collected too.
    }
}


public class Tpc9_PluggableExceptionHandler {

	public static void main(String[] args) {
		
		
	}

}
