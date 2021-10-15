public class Stats {
    private int minimum;
    private int maximum;
    private double average;

    public Stats (int minimum, int maximum, double average) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.average = average;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
