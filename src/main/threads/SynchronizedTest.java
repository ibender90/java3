package threads;

public class SynchronizedTest {
    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread th1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        });

        Thread th2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.decrement();
            }
        });

        th1.start(); //один из потоков запустит синхронизованный метод, а значит захватит монитор
        // второй поток будет дожидаться освобождения монитора для запуска синхронизированного метода
        // монитором выступает объект counter
        th2.start();
        try {
            th1.join();
            th2.join();
            //маин подождёт заверщения работы потоков
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getValue());
    }
}
