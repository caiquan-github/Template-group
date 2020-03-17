package chapter4.c2;

public abstract class ObservableRunnable implements Runnable {
	//这里的lifecyclelistener（接口） 利用了java多态的原理主要起到回调lifecyclelistener实现的方法
	final protected LifeCyclelistener listener;
	
	//构造函数将 LifeCyclelistener实现给this.listener
	public ObservableRunnable(final LifeCyclelistener  listener) {
		this.listener=listener;
	}
	
	//这里将被动接受监听者的信息  收到信息后并用该监听者的方法
	protected void notifyChange(final RunnableEvent event) {
		listener.onEvent(event);
	}
	
	//状态 枚举
	public enum RunnableState{
		RUNNING,ERROR,DONE
	}
	

	public static class RunnableEvent{
		//状态
		private final RunnableState state;
		//线程
		private final Thread thread;
		//异常
		private final Throwable cause;
		
		public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
			this.state = state;
			this.thread = thread;
			this.cause = cause;
		}

		public RunnableState getState() {
			return state;
		}

		public Thread getThread() {
			return thread;
		}

		public Throwable getCause() {
			return cause;
		}
	
		
	}

}
