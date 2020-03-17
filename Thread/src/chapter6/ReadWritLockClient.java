package chapter6;

/*
 * 读写分离
 * */
public class ReadWritLockClient {

	public static void main(String[] args) {
		final SharedData data=new SharedData(10);
		new ReaderWorker(data).start();
		new ReaderWorker(data).start();
		new ReaderWorker(data).start();
		new ReaderWorker(data).start();
		new WriterWorker(data, "thisWidata").start();
		new WriterWorker(data, "THISWIDATA").start();
	}
}
