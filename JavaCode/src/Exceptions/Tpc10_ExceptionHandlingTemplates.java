package Exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



public class Tpc10_ExceptionHandlingTemplates {

	/*
	 * Correct Error Handling is Tedious to Write
	 * 
	 * Correct exception handling code can be tedious to write. 
	 * Try-catch blocks also clutter the code and makes it harder to read.
	 * 
	 */
	public void approach1(String fileName) {
		
		InputStream input  = null;
	    IOException processException = null;
	    try{
	        input = new FileInputStream(fileName);

	        //...process input stream...
	    } catch (IOException e) {
	        processException = e;
	    } finally {
	       if(input != null){
	          try {
	             input.close();
	          } catch(IOException e){
	             if(processException != null){
	                throw new MyException(processException, e,
	                  "Error message..." +
	                  fileName);
	             } else {
	                throw new MyException(e,
	                    "Error closing InputStream for file " +
	                    fileName);
	             }
	          }
	       }
	    }
	    if(processException != null){
	          throw new MyException(processException,
	            "Error processing InputStream for file " +
	                fileName);
	    } 
	}
	
    
	

	public static void main(String[] args) {

		/*
		 * All the exception handling is encapsulated inside the
		 * InputStreamProcessingTemplate class. Notice how the process()
		 * method calls the doProcess() method inside the try-catch block.
		 * You will use the template by subclassing it, and overriding the 
		 * doProcess() method. To do this, you could write:
		 * 
		 * This example creates an anonymous subclass of the
		 * InputStreamProcessingTemplate class, instantiates an instance
		 * of the subclass, and calls its process() method.
		 * 
		 * This is a lot simpler to write, and easier to read. Only the
		 * domain logic is visible in the code. The compiler will check that
		 * you have extended the InputStreamProcessingTemplate correctly.
		 * 
		 * You can now reuse the InputStreamProcessingTemplate in any place
		 * in your code where you need to process a file input stream. You 
		 * can easily modify the template to work for all input streams and 
		 * not just files.
		 * 
		 */

		new InputStreamProcessingTemplate1(){
	        public void doProcess(InputStream input) throws IOException{
	            int inChar = input.read();
	            while(inChar != -1){
	                //do something with the chars...
	            }
	        }
	    }.process("someFile.txt");
	    

	    
	    /*
	     * Using Interfaces Instead of Sub classing
	     *
	     * Instead of sub classing the InputStreamProcessingTempate you 
	     * could rewrite it to take an instance of an InputStreamProcessor
	     * interface.
	     * 
	     */
	    
	    new InputStreamProcessingTemplate2()
        .process("someFile.txt", new InputStreamProcessor(){
            public void doProcess(InputStream input) throws IOException{
                int inChar = input.read();
                while(inChar != -1){
                    //do something with the chars...
                }
            }

			
        });
	    
	    
	}

}

/*
 * That is how much code it takes to handle the processing of an
 * input stream without any exceptions being lost. In fact it only
 * even catches IOExceptions. RuntimeExceptions thrown from the 
 * try-block are not preserved, if the input.close() call also
 * throws an exception. Isn't it ugly? Isn't it hard to read what
 * is actually going on? Would you remember to write all that code
 * every time you process an input stream?
 *
 * Luckily there is a simple design pattern, the Template Method,
 * that can help you get the exception handling right everytime, 
 * without ever seeing or writing it in your code.
 * 
 * Well, maybe you will have to write it once, but that's it.
 * 
 * What you will do is to put all the exception handling code
 * inside a template. The template is just a normal class. Here
 * is a template for the above input stream exception handling:
 * 
 * 
 */

abstract class InputStreamProcessingTemplate1 {

    public void process(String fileName){
        IOException processException = null;
        InputStream input = null;
        try{
            input = new FileInputStream(fileName);

            doProcess(input);
        } catch (IOException e) {
            processException = e;
        } finally {
           if(input != null){
              try {
                 input.close();
              } catch(IOException e){
                 if(processException != null){
                    throw new MyException(processException, e,
                      "Error message..." +
                      fileName);
                 } else {
                    throw new MyException(e,
                        "Error closing InputStream for file " +
                        fileName);
                 }
              }
           }
        }//finally
           if(processException != null){
              throw new MyException(processException,
                "Error processing InputStream for file " +
                    fileName);
           }
    }

    //override this method in a subclass, to process the stream.
    public abstract void doProcess(InputStream input) throws IOException;
}


/*
 * Notice the extra parameter in the template's process() method.
 * This is the InputStreamProcessor, which is called from inside 
 * the try block (processor.doProcess(input)). 
 * 
 */
interface InputStreamProcessor {
    public void doProcess(InputStream input) throws IOException;
}

class InputStreamProcessingTemplate2 {

    public void process(String fileName, InputStreamProcessor processor){
        IOException processException = null;
        InputStream input = null;
        try{
            input = new FileInputStream(fileName);

            processor.doProcess(input);
        } catch (IOException e) {
            processException = e;
        } finally {
           if(input != null){
              try {
                 input.close();
              } catch(IOException e){
                 if(processException != null){
                    throw new MyException(processException, e,
                      "Error message..." +
                      fileName);
                 } else {
                    throw new MyException(e,
                        "Error closing InputStream for file " +
                        fileName);
                 }
              }
           }
        }//finally
           if(processException != null){
              throw new MyException(processException,
                "Error processing InputStream for file " +
                    fileName);
           }
    }
}

    