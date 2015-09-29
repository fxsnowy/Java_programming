package snmp;

import java.lang.*;
import java.util.*;

import com.adventnet.snmp.snmp2.SnmpAPI;
import com.adventnet.snmp.snmp2.SnmpException;
import com.adventnet.snmp.snmp2.SnmpOID;
import com.adventnet.snmp.snmp2.SnmpPDU;
import com.adventnet.snmp.snmp2.SnmpSession;
import com.adventnet.snmp.snmp2.SnmpVarBind;


public class uwmAvg {
	Timer timer;
	String remoteHost;
    String OID;
    int pollingPeriod;
    int numOfPoll;
    int count;
    float throughPut ;
    int lastValue;
    int traffic;
    int[] value; 
    int arrIndex;

    
    public uwmAvg(String oid, int pollPeriod, int num, String host) {
    	remoteHost = host;
	    OID = oid;
	    pollingPeriod = pollPeriod;
	    numOfPoll = num+1;
	    count=0;
	    traffic= 0;
	    //value = new Vector(pollingPeriod);
	    value = new int[numOfPoll];
	    arrIndex =0;
	    throughPut = 0;
	    
	    System.out.println("Remote host is : " + remoteHost);
	    System.out.println("OID is  : " + OID);
	    System.out.println("Polling period is : " + pollPeriod);
	    System.out.println("Number of periods or window size is : " + (num));
	    
	    
        timer = new Timer();
        timer.schedule(new RemindTask(), 0, pollingPeriod *1000);
	    
        
    }
    
	class RemindTask extends TimerTask {
        public void run() {
        
        count++;
            
        // Start SNMP API
        SnmpAPI api;
   	    api = new SnmpAPI();
   	    api.start();
   		
   		// Open session
   		SnmpSession session = new SnmpSession(api); 

   		try {
   	            session.open();
   	        } catch (SnmpException e ) {
   		    System.err.println("Error opening socket: "+e);
   		   }

   		// set remote Host 
   		session.setPeername(remoteHost);

   		// Build Get request PDU
   		SnmpPDU pdu = new SnmpPDU();
   		pdu.setCommand( api.GET_REQ_MSG );

		SnmpOID oid = new SnmpOID(OID);
   	    pdu.addNull(oid);

   	     try {
   			     pdu = session.syncSend(pdu);
   			     //System.out.println(pdu.printVarBinds());
   			     SnmpVarBind snmpVar = pdu.getVariableBinding(0);
   
   		   		if(count == 1)
   		   			//lastValue=((Long)(snmpVar.getVariable().toValue())).intValue();
   		   		lastValue=((Long)(snmpVar.getVariable().toValue())).intValue();
   		   		

   			     traffic = ((Long)(snmpVar.getVariable().toValue())).intValue();
   			     System.out.println("Instantaneous traffic : " + traffic + " units/sec");
   			     traffic = traffic - lastValue;   //get the difference with the previous reading
   		   	     
   			     value[arrIndex]=traffic;
   			     arrIndex++;
   			     if(arrIndex == numOfPoll)
   			    	 arrIndex = 0;
   			    	 
   			        
   			     if (count > 1)
   			    	lastValue = ((Long)(snmpVar.getVariable().toValue())).intValue();

   			     
    			        
   	         } catch (Throwable e) {
   		       System.err.println("Error sending SNMP request: "+e);
   		     }
   	    
   		
   		 // close session
   		session.close();
   		
   		// stop api thread
   		api.close();
   		

  		if (count >= numOfPoll)
        {
  		   throughPut = 0;
  		   for(int i=0; i<numOfPoll; i++)
           {
  			 //System.out.println("value " + value[i]);
  			 throughPut = throughPut + value[i];
           }
  		    
       		throughPut =throughPut/(numOfPoll -1);
       		throughPut = throughPut/pollingPeriod;
       		System.out.println("Uniformly weighted moving average is " + throughPut + " units/sec.");
       		//timer.cancel(); //Terminate the timer thread

        }
               
        }
    }
	
	public static void main(String args[]) {
	    
	    if( args.length < 4)
		{
			System.out.println("Usage : java uwmAvg OID pollPeriod numPeriod hostname ");
			System.exit(0);
		}
	        
		// Store the args in the corresponding variable
		String host = args[3];
	    String oid = args[0];
	    int period = Integer.parseInt(args[1]);
	    int num = Integer.parseInt(args[2]);
	    
	    new uwmAvg(oid,period,num,host);
				
	 }

}


