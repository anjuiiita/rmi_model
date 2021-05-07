import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class CmdRegister implements Runnable {

    CmdRegister() {}

    public void run() {
        CmdAgentImpl obj = new CmdAgentImpl();
        try {        
            CmdAgent stub = (CmdAgent) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("CmdAgent", stub);
            System.err.println("CmdRegister Server ready");
         } catch (RemoteException e) { 
            System.err.println("CmdRegister Agent exception: " + e.toString()); 
         } catch ( AlreadyBoundException ex) {
            System.err.println("The RMI binding is already in place.");
         }
    }
}


