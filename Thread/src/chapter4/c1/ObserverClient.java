package chapter4.c1;

public class ObserverClient {
	
	public static void main(String[] args) {
		final Subject subject=new Subject();
		new BinaryObserver(subject);
		new OctalObserver(subject);
		subject.setState(10);
	}
	
}
