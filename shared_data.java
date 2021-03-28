import java.util.*;

public class shared_data {
    Map<String, Integer> beacons = new HashMap<String, Integer>();
    Map<String, Boolean> dead_client = new HashMap<String, Boolean>(); 

    public synchronized void addBeacons(String agentID, int time) {
        this.beacons.put(agentID, time);
    }

    public synchronized void removeBeacons(String agentID) {
        this.beacons.remove(agentID);
    }

    public synchronized void addDeadAgent(String agentID) {
        this.dead_client.put(agentID, true);
    }

    public synchronized void deleteDeadAgent(String agentID) {
        this.dead_client.remove(agentID);
    }
    
}
