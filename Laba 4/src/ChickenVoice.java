import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class ChickenVoice {

    static EggVoice mAnotherOpinion;
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        mAnotherOpinion = new EggVoice(reentrantLock);
        Thread thread = new Thread(mAnotherOpinion);

        System.out.println("Початок суперечки");
        thread.start();

        for (int i = 0; i < 5; i++) {
            try {
                sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Курка");
        }

            if (reentrantLock.tryLock()) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Першим було яйце");
            }
            else {
                System.out.println("Першою була курка");
            }
            System.out.println("Завершення суперечки");
    }


}
