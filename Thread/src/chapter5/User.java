package chapter5;

public class User extends Thread {
	private final String myName;
	private final String myAddress;
	private final Gate gate;
	
	public User(String myName, String myAddress, Gate gate) {
		this.myName = myName;
		this.myAddress = myAddress;
		this.gate = gate;
	}
	
	@Override
	public void run() {
		System.out.println(myName+"BEGIN");
		while(true) {
			this.gate.pass(myName, myAddress);
		}
	}
	

}
