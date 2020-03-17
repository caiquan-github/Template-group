package chapter8;

public class SyncInvoker {
	public static void main(String[] args) throws InterruptedException {
		FutureServier futureServier=new FutureServier();
		Future<String> future=futureServier.submit(()->{
			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "FINISH";
		},System.out::println);
		System.out.println("=========");
		Thread.sleep(1000);
		System.out.println("=========");
		
	}

}
