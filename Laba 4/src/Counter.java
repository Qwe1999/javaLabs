import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

class Counter {
    private int c = 0;
    private ReentrantLock reentrantLock;

    public Counter(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    public void increment() throws InterruptedException {
        reentrantLock.lock();
        int a;
        a = c;
        sleep(150);
        a++;
        c = a;
        reentrantLock.unlock();
    }
    public void decrement() throws InterruptedException {
        int a;
        a = c;
        sleep(100);
        a--;
        c = a;
    }
    public int value() {
        return c;
    }
}