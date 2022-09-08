package threads;

public class Main {
    public static void main(String[] args) {
//        Thread th1 = new Thread(new Homework4Runnable());
//        Thread th2 = new Thread(new Homework4Runnable());

        Homework4Thread th1 = new Homework4Thread();
        Homework4Thread th2 = new Homework4Thread();

        Thread anonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(i + " from anon Thread");
                }
            }
        });

        Thread threadWithLambda = new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println(i + " from Thread with lambda");
            }
        });
        System.out.println("main thread is started");

        // потоки будут запущены параллельно, какой начнет, а какой закончит первым неизвестно
        threadWithLambda.start();
        anonThread.start();
//        th1.start();
//        th2.start();

        try {
            anonThread.join(); //join вызваный для потока из main метода ожидает сначала завершения выполнения
            //этого потока (тут anonThread) и только потом возобновляется работа main потока
            threadWithLambda.join(); // main ждёт threadWithLambda
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("last words from Main");

    }
}
