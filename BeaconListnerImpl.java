import java.time.Instant;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class BeaconListnerImpl implements BeaconListener {

    shared_data obj = null;
    public BeaconListnerImpl(shared_data obj) {
        this.obj = obj;
    }
    
    public void deposit(Beacon beacon){
        int now_time = (int)Instant.now().getEpochSecond();
        if (this.obj.beacons.containsKey(beacon.CmdAgentID)) {
            this.obj.addBeacons(beacon.CmdAgentID, now_time);
            System.out.println("Beacon received from agent " + beacon.CmdAgentID);
        } else {
            if (this.obj.dead_client.containsKey(beacon.CmdAgentID)) {
                this.obj.addBeacons(beacon.CmdAgentID, now_time);
                System.out.println("Agent " + beacon.CmdAgentID + " resurrected");
                this.obj.deleteDeadAgent(beacon.CmdAgentID);
            } else {
                System.out.println("New agent found with ID " + beacon.CmdAgentID);
                this.obj.addBeacons(beacon.CmdAgentID, (int)Instant.now().getEpochSecond());
            }
            
            try {  
                // Getting the registry 
                Registry registry = LocateRegistry.getRegistry(null); 
           
                // Looking up the registry for the remote object 
                CmdAgent stub = (CmdAgent) registry.lookup("CmdAgent"); 
                
                String CmdID = "GetLocalTime";
                GetLocalTime CmdObj = new GetLocalTime();
                CmdObj.valid = 0;
                GetLocalTime local = stub.executeTime(CmdID, CmdObj);
                if (local.valid == 1)
                    System.out.println( "Agent local time " + local.time);
                CmdID = "GetVersion";
                GetVersion VerObj = new GetVersion();
                GetVersion version = stub.executeVersion(CmdID, VerObj);
                System.out.println( "Agent local version " + version.version);
             } catch (Exception e) {
                System.err.println("BeaconListener Client exception: " + e.toString()); 
                e.printStackTrace(); 
             }
        }
    }
    
}
