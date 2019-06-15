package entities;

public class Driver {
    private long id;
    private String name;
    private double value1;
    private double value2;
    private String supplier;

    public Driver(String name, double value1, double value2) {
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
    }

    public Driver(long id, String name, double value1, double value2, String supplier) {
        this.id = id;
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
        this.supplier = supplier;
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

    public long getId() {
        return id;
    }

    public String getSupplier() {
        return supplier;
    }
}
