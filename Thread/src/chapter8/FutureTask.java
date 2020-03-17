package chapter8;
/*
 * 任务接口 重写call方法 call方法内容为任务内容
 * */
public interface FutureTask<T> {
	T call();

}
