import java.lang.Thread;

public class Agent
{ 
	public static void main(String[] args)
	{ 

		// created two threads to simulated tcp and udp server.
        Thread rmi1 = new Thread(new BeaconSender()); 
        rmi1.start(); 

		Thread rmi2 = new Thread(new CmdRegister());
		rmi2.start();
	}
}