package chapter5;

public class Client {

	public static void main(String[] args) {
		Gate gate =new Gate();
		User bj =new User("Baobao", "Beijing", gate);
		User sh =new User("Shangmei", "Shanghai", gate);
		User gz =new User("Guanglao", "Guangzhou", gate);
		bj.start();
		sh.start();
		gz.start();
	}
}
