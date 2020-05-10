import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class EggVoice implements Runnable {


    ReentrantLock reentrantLock;

    public EggVoice(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        for (int i = 0; i < 5; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("яйце");
        }
        reentrantLock.unlock();
    }
}
