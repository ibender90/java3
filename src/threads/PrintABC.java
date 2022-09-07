package threads;

public class PrintABC {
    private final Object monitor = new Object();
    private volatile char letterToPrint = 'A';

    private void printA(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (letterToPrint != 'A'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("A");
                letterToPrint = 'B';
                monitor.notifyAll();
            }
        }
    }
    private void printB(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (letterToPrint != 'B'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("B");
                letterToPrint = 'C';
                monitor.notifyAll();
            }
        }
    }
    private void printC(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (letterToPrint != 'C'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("C");
                letterToPrint = 'A';
                monitor.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC printer = new PrintABC();
        Thread t1 = new Thread(()->{
            printer.printA();
        });
        Thread t2 = new Thread(()->{
            printer.printB();
        });
        Thread t3 = new Thread(()->{
            printer.printC();
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
