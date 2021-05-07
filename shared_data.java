
import java.util.concurrent.*;

public class shared_data {
    ConcurrentHashMap<String, Integer> beacons = new ConcurrentHashMap<String, Integer>();
    ConcurrentHashMap<String, Boolean> dead_client = new ConcurrentHashMap<String, Boolean>(); 

    public synchronized void addBeacons(String agentID, int time) {
        this.beacons.put(agentID, time);
    }

    public synchronized void removeBeacons(String agentID) {
        if (this.beacons.containsKey(agentID))
            this.beacons.remove(agentID);
    }

    public synchronized void addDeadAgent(String agentID) {
        this.dead_client.put(agentID, true);
    }

    public synchronized void deleteDeadAgent(String agentID) {
        if (this.dead_client.containsKey(agentID))
            this.dead_client.remove(agentID);
    }
    
}
