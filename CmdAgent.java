import java.rmi.*;

public interface CmdAgent extends java.rmi.Remote {     
    public GetLocalTime executeTime(String CmdID, GetLocalTime CmdObj) throws RemoteException;
    public GetVersion executeVersion(String CmdID, GetVersion CmdObj) throws RemoteException;
}