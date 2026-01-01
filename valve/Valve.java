package valve;

public class Valve {
    private boolean on;
    public int livello;

    public synchronized boolean isOn() {
        return on;
    }

    public synchronized void setOn(boolean newState) {
        on = newState;
    }

    public synchronized int getLevel() {
        return livello;
    }

    public synchronized void setLevel(int newLevel) {
        livello = newLevel;
    }
}
