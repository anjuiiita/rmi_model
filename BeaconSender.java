import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.time.Instant;
import java.io.*;

public class BeaconSender implements Runnable {

    BeaconSender() {
    }

    public void run() {
        try {  
            // Getting the registry 
            Registry registry = LocateRegistry.getRegistry(null); 
       
            // Looking up the registry for the remote object 
            BeaconListener stub = (BeaconListener) registry.lookup("BeaconListener"); 
       
            // Calling the remote method using the obtained object
            System.out.println("Please provide agent ID");
            Console console = System.console();
            String agentId = console.readLine();
            while(true) {
                System.out.println("Sending beacon");
                int ID = 1; 
                int startUpTime = (int)Instant.now().getEpochSecond();
                String CmdAgentID = agentId;
                Beacon b = new Beacon(ID, startUpTime, CmdAgentID);
                stub.deposit(b); 
                Thread.sleep(5000);
            }
            
            // System.out.println("Remote method invoked"); 
         } catch (Exception e) {
            System.err.println("BeaconListener Client exception: " + e.toString()); 
            e.printStackTrace(); 
         }
    }
}
