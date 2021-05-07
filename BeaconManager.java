import java.time.Instant;
import java.util.*;

public class BeaconManager implements Runnable {

    shared_data bObj = null;

    BeaconManager(shared_data obj) {
        this.bObj = obj;
    }

    public void run() 
    { 
        try {
            
            while(true) {
                int now_time = (int)Instant.now().getEpochSecond();
                Iterator<Map.Entry<String,Integer>> it;
                Map.Entry<String, Integer> entry;
                it = bObj.beacons.entrySet().iterator();
                while (it.hasNext()) {
                //for (Map.Entry<String, Integer> entry: bObj.beacons.entrySet()) {
                    entry = it.next();
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
        }
    }
}
