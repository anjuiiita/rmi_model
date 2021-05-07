import java.io.*;

// Beacon that udp send every certain interval to server
public class Beacon implements Serializable  {
    public int ID; 
    public int startUpTime;  
    public String CmdAgentID;
    private static final long serialVersionUID = 1L;

    Beacon(int ID, int startUpTime, String CmdAgentID) {
        this.ID = ID;
        this.startUpTime = startUpTime;
        this.CmdAgentID = CmdAgentID;
    }
    

    // Getter
    public int getID() {
        return ID;
    }
    public int getstartUpTime() {
        return startUpTime;
    }
    public String getCmdAgentID() {
        return CmdAgentID;
    }

    // Setter
    public void setID(int newID) {
        this.ID = newID;
    }
    public void setStartUpTime(int newStartUpTime) {
        this.startUpTime = newStartUpTime;
    }
    public void setIP(String CmdAgentID) {
        this.CmdAgentID = CmdAgentID;
    }


    public static void main(String[] args) throws IOException {
    }
}
