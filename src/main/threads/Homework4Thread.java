package threads;

public class Homework4Thread extends Thread{
    //создаю интсанс класса Homework4 и обращаюсь к его методу .start
    //Homework4Thread th1 = new Homework4Thread(); th1.start;

    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " from class which extends thread");
        }
    }
}
