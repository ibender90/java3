package threads;

public class Homework4Runnable implements Runnable{
    //чтобы выполнять функцию этого класса в новом потоке нужно
    // передать в конструктор класса Thread новый инстанс калсса homework4
    // Thread th1 = new Thread(new Homework4());
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " from class which implements runnable");
        }
    }
}

