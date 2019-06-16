package entities;

public class Supplier {
    private long id;
    private String name;
    private double theftChance;

    public Supplier(long id, String name, double theftChance) {
        this.id = id;
        this.name = name;
        this.theftChance = theftChance;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTheftChance() {
        return theftChance;
    }
}
