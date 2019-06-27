package entities;

/**
 * Supplier class stores provided user input data about supplier.
 */
public class Supplier {
    private long id;

    /**
     * Name of the supplier.
     */
    private String name;

    /**
     * Chance for any driver working for the supplier to steal fuel during delivery.
     */
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
