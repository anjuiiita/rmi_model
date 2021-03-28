import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.server.UnicastRemoteObject;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class CmdRegister extends CmdAgentImpl implements Runnable {

    public void run() {
        try { 

            CmdAgentImpl obj = new CmdAgentImpl();
            CmdAgent stub = (CmdAgent) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("CmdAgent", stub);
            System.err.println("CmdRegister Server ready");
         } catch (RemoteException e) { 
            System.err.println("CmdRegister Agent exception: " + e.toString()); 
         } catch(AlreadyBoundException e) {
            //System.err.println("CmdRegister Agent exception: " + e.toString());
         }
    }
}


