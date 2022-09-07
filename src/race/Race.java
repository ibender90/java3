package race;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void startSameTime(){
        try {
            Car.getCar().getLatch().await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
