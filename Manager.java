import java.lang.Thread;

public class Manager
{ 
	public static void main(String[] args)
	{
		shared_data bObj = new shared_data();

		Thread rmi1 = new Thread(new BeaconListenerRegister(bObj));

        Thread rmi2 = new Thread(new BeaconManager(bObj)); 

		rmi1.start();
		rmi2.start();
	}
}