package threads;

public class SynchDoubleCounter {

    private long first;
    private long second;
    private Object monFirst = new Object();
    private Object monSecond = new Object();

    public long getFirst() {
        return first;
    }

    public long getSecond() {
        return second;
    }

    public void incrementFirst() {
        synchronized (monFirst) {
            first++;
        }
    }

    public void incrementSecond() {
        synchronized (monSecond) {
            second++;
        }
    }

    public void decrementFirst() {
        synchronized (monFirst) {
            first--;
        }
    }

    public void decrementSecond() {
        synchronized (monSecond) {
            second--;
        }
    }

}
