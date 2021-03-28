import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;


public class BeaconListenerRegister extends BeaconListnerImpl implements Runnable {

    shared_data bObj = null;
    BeaconListenerRegister(shared_data obj) {
        super(obj);
        this.bObj = obj;
    }
    
    public void run() 
    {
        try {
            BeaconListnerImpl obj = new BeaconListnerImpl(this.bObj);
            BeaconListener stub = (BeaconListener) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("BeaconListener", stub);

            System.err.println("Beacon Listener Server ready");
            
        } catch (Exception e) {
            System.err.println("Beacon Listener Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
