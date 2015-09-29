package snmp;

import java.lang.*;
import java.util.Vector;

import com.adventnet.snmp.snmp2.SnmpAPI;
import com.adventnet.snmp.snmp2.SnmpException;
import com.adventnet.snmp.snmp2.SnmpOID;
import com.adventnet.snmp.snmp2.SnmpPDU;
import com.adventnet.snmp.snmp2.SnmpSession;
import com.adventnet.snmp.snmp2.SnmpVarBind;

public class tcpConMgr {
	public static void main(String args[]) {
	    
	    if( args.length < 2)
		{
			System.out.println("Usage : java SnmpGetNext hostname OID ");
			System.exit(0);
		}
	        
		//Assign the states to array
	    String states[] = {
	    		"undefined(0)",
                "closed(1)",
                "listen(2)",
                "synSent(3)",
                "synReceived(4)",
                "established(5)",
                "finWait1(6)",
                "finWait2(7)",
                "closeWait(8)",
                "lastAck(9)",
                "closing(10)",
                "timeWait(11)",
                "deleteTCB(12)"
            };
	    
	    // Take care of getting the hostname and the OID
		String remoteHost = args[0];
	    String OID = args[1];
	    int oidLength = OID.length();
	    //System.out.println(oidLength);
		
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

		// Build GetNext request PDU
		SnmpPDU pdu = new SnmpPDU();
		pdu.setCommand( api.GETNEXT_REQ_MSG );

		// add OIDs
		for (int i=1; i<args.length; i++){

		    SnmpOID oid = new SnmpOID(args[i]);
		    pdu.addNull(oid);

		}    

		System.out.println("     local addr    |" + "     local port    |" + "     remote addr    |" + "     remote port    |" + "     state    ");
		//System.out.println( "    " + "localAddr" + "    " +  "localPort" + "     " + "remoteAddr"  + "    " + "remotePort" + "    " + "states");
		String checkId = OID;
		do{
		    try {
			     pdu.setCommand(SnmpAPI.GETNEXT_REQ_MSG); 
		         // Send PDU and receive response PDU
			     pdu = session.syncSend(pdu);
	         } catch (SnmpException e) {
		       System.err.println("Error sending SNMP request: "+e);
		     }    	
		
	         SnmpVarBind snmpVar = pdu.getVariableBinding(0);
	         //convert oid to string to manipulate later
	         String objId = snmpVar.getObjectID().toString();
	         //extract the oid ta later check when exit the table
	         checkId = objId.substring(0,oidLength);
	         //extract local host, port....
	         objId = objId.substring(oidLength+1, objId.length());
	         //tokenise the later part of the oid (host,port...)
	         String addr[] = objId.split("[.]");
	         //check if the the oid belongs to the table, also pass the information to a string to be displayed
	         if (OID.equals(checkId))
	         {
	        	 String strLocalAddr = "                   |";	 
	        	 String localAddr = addr[0] + "." + addr[1] + "." + addr[2] + "." + addr[3];
	        	 localAddr = localAddr + strLocalAddr.substring(localAddr.length()+4);
	        	 
	        	 String strLocalPort = "                   |";
	        	 String localPort = addr[4];
	        	 localPort = localPort + strLocalPort.substring(localPort.length() + 4);
	        	 
	        	 String strRemoteAddr = "                    |";
	        	 String remoteAddr = addr[5] + "." + addr[6] + "." + addr[7] + "." + addr[8];
	        	 remoteAddr = remoteAddr + strRemoteAddr.substring(remoteAddr.length()+5);
	        	 
	        	 String strRemotePort = "                    |";
	        	 String remotePort = addr[9];
	        	 remotePort = remotePort + strRemotePort.substring(remotePort.length() + 4);
	        	 	        	 
	        	 Integer ival = (Integer)(snmpVar.getVariable().toValue());

	        	 System.out.println( "    " + localAddr + "    " +  localPort + "     " + remoteAddr  + "    " + remotePort + "    " + states[ival.intValue()]);
		        
	         }
	         else
	        	 break;
		     
		}while(OID.equals(checkId));
		
		 // close session
		session.close();
		
		// stop api thread
		api.close();
		
	 }
	

}
