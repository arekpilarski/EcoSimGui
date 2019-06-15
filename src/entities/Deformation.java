package entities;

public class Deformation {
    private long id;
    private double value1;
    private double value2;
    private String Tank;

    public Deformation(long id, double value1, double value2, String tank) {
        this.id = id;
        this.value1 = value1;
        this.value2 = value2;
        Tank = tank;
    }

    public long getId() {
        return id;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public String getTank() {
        return Tank;
    }
}
