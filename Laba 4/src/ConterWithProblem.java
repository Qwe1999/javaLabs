
import static java.lang.Thread.sleep;

class CounterWithProblem {
    private int c = 0;

    public void increment() throws InterruptedException {
        int a;
        a = c;
        sleep(150);
        a++;
        c = a;
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
