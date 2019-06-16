package entities;

public class Deformation {
    private long id;
    private double height;
    private double value;
    private long tankId;

    public Deformation(long id, double height, double value, long tankId) {
        this.id = id;
        this.height = height;
        this.value = value;
        this.tankId = tankId;
    }

    public long getId() {
        return id;
    }

    public double getHeight() {
        return height;
    }

    public double getValue() {
        return value;
    }

    public long getTankId() {
        return tankId;
    }
}
