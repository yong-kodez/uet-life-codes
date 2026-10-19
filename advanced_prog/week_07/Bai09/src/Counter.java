import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final ReentrantLock lock = new ReentrantLock();
    private int value = 0;
    
    public void increment() {
        lock.lock();
        try {
            value += 1;
        } finally {
            lock.unlock();
        }
    }

    public void incrementTryLock() {
        if (lock.tryLock()) {
            try {
                value += 1;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ": can't acquire lock");
        }
    }

    public int getValue() { return value; }
}
