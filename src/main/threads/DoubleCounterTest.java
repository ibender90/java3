package threads;

public class DoubleCounterTest {
    public static void main(String[] args) {
        SynchDoubleCounter counter = new SynchDoubleCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.incrementFirst();
                System.out.println("t1 works");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.decrementFirst();
                System.out.println("t2 works");
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.incrementSecond();
                System.out.println("t3 works");
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.decrementSecond();
                System.out.println("t4 works");
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getFirst() + " first counter");
        System.out.println(counter.getSecond() + " second counter");
    }
}
