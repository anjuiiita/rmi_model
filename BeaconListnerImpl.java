import java.time.Instant;
import java.rmi.registry.Registry;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class BeaconListnerImpl extends BeaconListenerRegister implements BeaconListener {

    shared_data obj = null;
    BeaconListnerImpl(shared_data obj) {
        super(obj);
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
            
                try {  
                    // Getting the registry 
                    Registry registry = LocateRegistry.getRegistry(null); 
            
                    // Looking up the registry for the remote object 
                    CmdAgent stub = (CmdAgent) registry.lookup("CmdAgent"); 
                    
                    String CmdID = "GetLocalTime";
                    GetLocalTime CmdObj = new GetLocalTime();
                    CmdObj.valid = 0;
                    GetLocalTime local = stub.executeTime(CmdID, CmdObj);
                    java.util.Date dateTime=new java.util.Date((long)local.time*1000);
                    if (local.valid == 1)
                        System.out.println( "Local time : " + dateTime);
                    else 
                        System.out.println("Local time is not valid");
                    CmdID = "GetVersion";
                    GetVersion VerObj = new GetVersion();
                    GetVersion version = stub.executeVersion(CmdID, VerObj);
                    System.out.println( "Local C version : " + version.version);
                } catch (RemoteException | NotBoundException e) {
                    System.err.println("BeaconListener Server exception: " + e.toString());
                }
            }
        }
    }
    
}
