import java.time.Instant;
import java.util.*;

public class BeaconManager extends BeaconListnerImpl implements Runnable {

    shared_data bObj = null;

    BeaconManager(shared_data obj) {
        super(obj);
        this.bObj = obj;
    }

    public void run() 
    { 
        try {
            
            while(true) {
                int now_time = (int)Instant.now().getEpochSecond();
                for (Map.Entry<String, Integer> entry: bObj.beacons.entrySet()) {
                    if (now_time - entry.getValue() > 10) {
                        System.out.println("Agent " + entry.getKey() + " is Dead!");
                        bObj.addDeadAgent(entry.getKey());
                        bObj.removeBeacons(entry.getKey());
                    }
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println("BeaconManager Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
