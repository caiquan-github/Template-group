package chapter6;

/*
 * 这里只是作用与读写的锁类 不直接参与数据的读写
 * */
public class ReadWriteLock {
	private int readingReaders = 0; // 正在读的数量
	private int waitingReaders = 0; // 正在等待的读数量
	private int writingWriters = 0; // 正在写的数量
	private int waitingWriters = 0; // 正在等待写的数量
	private boolean preferWriter=true;

	public ReadWriteLock() {
		this(true);
	}
	
	public ReadWriteLock(boolean preferWriter) {
		this.preferWriter=preferWriter;
	}
	public synchronized void readLock() throws InterruptedException {
		this.waitingReaders++;
		try {
			while (writingWriters > 0||(preferWriter&&waitingWriters>0)) {
				this.wait();
			}
			this.readingReaders++;
		} finally {
			this.waitingReaders--;
		}
	}

	public synchronized void readUnlock() {
		this.readingReaders--;
		this.notifyAll();
	}

	public synchronized void writLock() throws InterruptedException {
		waitingWriters++;
		try {
			while (readingReaders > 0 || writingWriters > 0) {
				this.wait();
			}
		} finally {
			waitingWriters--;
		}
	}
	
	public synchronized void writunlock() {
		this.waitingWriters--;
		this.notifyAll();
	}

}
