package chapter8;

import java.util.function.Consumer;

public class FutureServier {
	
	public <T> Future<T> submit(final FutureTask<T> task){
		AsynFuture<T> asynFuture=new AsynFuture<T>();
		//使用多线程去执行任务，不会导致阻塞
		new Thread(()->{
			//调用要执行的任务
			T result=task.call();
			//任务执行完进行通知
			asynFuture.done(result);
		}).start();
		//直接返回 创建的asynFuture
		return asynFuture;
	}
	
	public <T> Future<T> submit(final FutureTask<T> task,final Consumer<T> consumer){
		AsynFuture<T> asynFuture=new AsynFuture<T>();
		new Thread(()->{
			T result=task.call();
			asynFuture.done(result);
			consumer.accept(result);
		}).start();
		return asynFuture;
	}
}
