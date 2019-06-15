package entities;

public class Supplier {
    private long id;
    private String name;
    private double value1;
    private double value2;

    public Supplier(long id, String name, double value1, double value2) {
        this.id = id;
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
    }

    public long getId() {
        return id;
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
}
