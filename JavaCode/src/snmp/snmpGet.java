package snmp;

import java.lang.*;
import java.util.*;
import java.net.*;
import com.adventnet.snmp.snmp2.*;

public class snmpGet {

public static void main(String args[]) {
    
            if( args.length < 2)
	{
		System.out.println("Usage : java SnmpGet hostname OID ");
		System.exit(0);
	}
        
	// Take care of getting the hostname and the OID
	String remoteHost = args[0];
       	String OID = args[1];       
	
	 // Start SNMP API
        SnmpAPI api;
        api = new SnmpAPI();
        api.start();
	api.setDebug( true );
	
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

	// add OIDs

	for (int i=1; i<args.length; i++){

	    SnmpOID oid = new SnmpOID(args[i]);
	    pdu.addNull(oid);

	}    

	try {
	    // Send PDU and receive response PDU
	     pdu = session.syncSend(pdu);
         } catch (SnmpException e) {
	     System.err.println("Error sending SNMP request: "+e);
	   }    	
	
	// print the response pdu varbinds
	System.out.println(pdu.printVarBinds());
	
	//SnmpVarBind snmpVar=pdu.getVariableBinding(0);
	
	//System.out.println(snmpVar.getObjectID().toString());
	//System.out.println(snmpVar.getVariable().toValue());
	
	
	 // close session
	session.close();
	
	// stop api thread
	api.close();
	
 }

}
