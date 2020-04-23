import java.util.concurrent.locks.ReentrantLock;

public class Main implements Runnable  {
    static Counter counter;
    public static void main(String[] args){
        counter = new Counter(new ReentrantLock());

        Thread thread1 = new Thread(new Main());
        Thread thread2 = new Thread(new Main());
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        try {
            counter.increment();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.value());
    }
}
