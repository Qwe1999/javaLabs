import java.util.concurrent.locks.ReentrantLock;

public class Main   {
    static Counter counter;
    static CounterWithProblem counterWithProblem;

    public static void main(String[] args){
        counterWithProblem = new CounterWithProblem();
        counter = new Counter(new ReentrantLock());

        System.out.println("Частина з проблемою синхронізації");
        Thread problemThread1 = new Thread(() -> {
            try {
                counterWithProblem.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counterWithProblem.value());
        });

        Thread problemThread2 = new Thread(() -> {
            try {
                counterWithProblem.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counterWithProblem.value());
        });

        problemThread1.start();
        problemThread2.start();

        try {
            problemThread1.join();
            problemThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Коректна частина:");

        Thread thread1 = new Thread(() -> {
            try {
                counter.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter.value());
        });

        Thread thread2 = new Thread(() -> {
            try {
                counter.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter.value());
        });

        thread1.start();
        thread2.start();
    }

}
