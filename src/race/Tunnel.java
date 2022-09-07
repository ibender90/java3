package race;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tunnel extends Stage {
    private ExecutorService tunnelService;
    private final Object monitor = new Object();

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        defineTunnelSize();
        tunnelService.execute(() -> {
            try {
                try {
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(c.getName() + " закончил этап: " + description);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void defineTunnelSize() {
        if (tunnelService == null) {
            synchronized (monitor) {
                tunnelService = Executors.newFixedThreadPool(Car.getCarsCount() / 2);
            }
        }
    }

}
