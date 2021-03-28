public class CmdAgentImpl implements CmdAgent {

    public native Object getCurrentLocalTime(GetLocalTime cmdObj);

    /*static {
        System.loadLibrary("client");
    }*/

    public Object execute(String CmdID, Object CmdObj) {
        if (CmdID.equals("GetLocalTime")) { 
            //CmdAgentClass cmd = new CmdAgentClass();    
            //return cmd.getCurrentLocalTime((GetLocalTime)CmdObj); 
            return CmdObj;  
        }
        return CmdObj;
    }
}
