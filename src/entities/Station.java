package entities;

public class Station {
    private long id;
    private String name;
    private double value1;
    private double value2;
    private double value3;

    public Station(long id, String name, double value1, double value2, double value3) {
        this.id = id;
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public String getName() {
        return name;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public double getValue3() {
        return value3;
    }

    public long getId() {
        return id;
    }
}
