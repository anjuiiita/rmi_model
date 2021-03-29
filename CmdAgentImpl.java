public class CmdAgentImpl implements CmdAgent {

    public native GetLocalTime getCurrentLocalTime(GetLocalTime cmdObj);
    public native GetVersion getlocalVersion(GetVersion cmdObj);

    static {
        final String dir = System.getProperty("user.dir");
        System.load(dir + "/client.so");
    }

    public GetLocalTime executeTime(String CmdID, GetLocalTime CmdObj) {
        if (CmdID.equals("GetLocalTime")) { 
            CmdAgentImpl cmd = new CmdAgentImpl();    
            return cmd.getCurrentLocalTime((GetLocalTime)CmdObj);
        } 
        return null;
    }

    public GetVersion executeVersion(String CmdID, GetVersion CmdObj) {
        if (CmdID.equals("GetVersion")) {
            CmdAgentImpl cmd = new CmdAgentImpl(); 
            return cmd.getlocalVersion((GetVersion)CmdObj);
        }
        return null;
    }
}
