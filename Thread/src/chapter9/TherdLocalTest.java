package chapter9;

public class TherdLocalTest {
	public static ThreadLocal  threadLocal=new ThreadLocal();
	
	public static void main(String[] args) {
	
		threadLocal.set("main");
		
		new Thread(()->{
			threadLocal.set("thread1");
			System.out.println(threadLocal.get());
		
		}).start();
		System.out.println(threadLocal.get());
		
		
	}
}
