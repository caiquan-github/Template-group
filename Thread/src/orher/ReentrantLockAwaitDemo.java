package orher;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockAwaitDemo {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        //测试Rlock
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                condition.await();
                System.out.println("被唤醒");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }).start();

        Thread.sleep(3000);

        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
