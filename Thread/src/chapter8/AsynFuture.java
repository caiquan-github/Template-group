package chapter8;

public class AsynFuture<T> implements Future<T>{
	private volatile boolean done=false;
	
	private T result;

	public void done(T result) {
		synchronized (this) {
			this.result=result;
			this.done=true;
			this.notifyAll();
		}
	}
	
	// 取出结果值
	@Override
	public T get() throws InterruptedException {
		synchronized (this) {
			//当done为true代表任务执行完毕 false  将进入wait()状态
			while(!done) {
				this.wait();
			}
		}
		
		return result;
	}

}
