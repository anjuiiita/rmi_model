import java.lang.Thread;

public class Agent
{ 
	public static void main(String[] args)
	{ 

		Thread rmi1 = new Thread(new CmdRegister());

		Thread rmi2 = new Thread(new BeaconSender()); 

		rmi1.start();
		rmi2.start();
	}
}