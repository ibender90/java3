package generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> collection = new ArrayList<T>();

    public void addFruits(T fruit) {
        collection.add(fruit);
    }

    public float getWeight() {
        if (collection.isEmpty()) {
            return 0;
        }

        float totalWeight = 0;

        for (Fruit everyFruit :
                collection) {
            totalWeight += everyFruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> anotherBox){
        return this.getWeight() == anotherBox.getWeight();
    }

    public void relocateFruits(Box<T> anotherBox){
        for (Fruit fruitToGo :
                this.collection) {
            anotherBox.addFruits((T) fruitToGo);
        }
        this.collection.clear();
    }
}
