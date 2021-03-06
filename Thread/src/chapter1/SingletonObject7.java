package chapter1;

/*
 * 推荐使用的单例 懒加载模式
 */
public class SingletonObject7 {
	private SingletonObject7() {
		
	}
	
	private enum Singleton{
		INSTANCE;
		
		private final SingletonObject7 instance;
		
		Singleton(){
			instance=new SingletonObject7();
		}
		
		public SingletonObject7 getInstance() {
			return instance;
		}
	}
	
	public static SingletonObject7 getInstance() {
		return Singleton.INSTANCE.getInstance();
	}
}
