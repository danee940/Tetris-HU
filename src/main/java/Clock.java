public class Clock {

    private float millisPerCycle;
    private long lastUpdate;
    private int elapsedCycles;
    private float excessCycles;
    private boolean isPaused;

    public Clock(final float cyclesPerSecond) {
        setCyclesPerSecond(cyclesPerSecond);
        reset();
    }

    public void setCyclesPerSecond(final float cyclesPerSecond) {
        this.millisPerCycle = (1.0f / cyclesPerSecond) * 1000;
    }

    public void reset() {
        this.elapsedCycles = 0;
        this.excessCycles = 0.0f;
        this.lastUpdate = getCurrentTime();
        this.isPaused = false;
    }

    public void update() {
        //Get the current time and calculate the delta time.
        final long currUpdate = getCurrentTime();
        final float delta = (float) (currUpdate - lastUpdate) + excessCycles;

        //Update the number of elapsed and excess ticks if we're not paused.
        if (!isPaused) {
            this.elapsedCycles += (int) Math.floor(delta / millisPerCycle);
            this.excessCycles = delta % millisPerCycle;
        }

        //Set the last update time for the next update cycle.
        this.lastUpdate = currUpdate;
    }

    public void setPaused(final boolean paused) {
        this.isPaused = paused;
    }

    public boolean hasElapsedCycle() {
        if (elapsedCycles > 0) {
            this.elapsedCycles--;
            return true;
        }
        return false;
    }

    private static long getCurrentTime() {
        return (System.nanoTime() / 1000000L);
    }
}
