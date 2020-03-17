package chapter1;

public class SingletonObject6 {
	
	private SingletonObject6() {
		
	}
	
	private static class InstanceHolder{
		private final static SingletonObject6 instance=new SingletonObject6();
	}
	
	public static SingletonObject6 getInstanceHolder() {
		return InstanceHolder.instance;
	}

}
