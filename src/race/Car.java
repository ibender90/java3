package race;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private static ArrayList<Car> cars = new ArrayList();
    private Race race;
    private CountDownLatch latch;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        cars.add(this);
    }

    private void linkCarsToLatch() {
        latch = new CountDownLatch(CARS_COUNT);
        for (Car car :
                cars) {
            car.latch = latch;
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            Thread.sleep(800); //чтобы успеть вывести сообщение, что каждый готов
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }

    public CountDownLatch getLatch() {
        linkCarsToLatch();
        return latch;
    }

    public static Car getCar() {
        return cars.get(0);
    }

    public static int getCarsCount() {
        return CARS_COUNT;
    }
}
