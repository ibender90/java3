package threads;

public class WaitNotifyExample {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        WaitNotifyExample wn = new WaitNotifyExample();

        Thread t1 = new Thread(() -> {
            wn.printA();
        });
        Thread t2 = new Thread(() -> {
            wn.printB();
        });
        t1.start();
        t2.start();
    }

    private void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'A';
                    monitor.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
