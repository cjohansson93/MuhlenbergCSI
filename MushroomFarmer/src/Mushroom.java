public class Mushroom {

    // Represents the days of life remaining on any given mushroom.
    private int daysRemaining;

    // Constructor
    public Mushroom(int lifespan) {
        this.daysRemaining = lifespan;
    }

    // Getter
    public int getDaysRemaining() {
        return daysRemaining;
    }

    /**
     * Expends the life of a mushroom by one from its initial lifespan.
     */
    public void expendLife() {
        this.daysRemaining -= 1;
    }
}