package entities;

/**
 * Driver class stores provided user input data about driver.
 */
public class Driver {
    private long id;

    /**
     * Driver's name.
     */
    private String name;

    /**
     * Driver's age.
     */
    private double age;

    /**
     * Chance for the driver to steal fuel during the delivery.
     */
    private double theftChance;

    /**
     * Name of the supplier the driver belongs to.
     */
    private String supplierName;

    /**
     * Id of the supplier the driver belongs to.
     */
    private long supplierId;

    public Driver(long id, String name, double age, double theftChance, String supplierName, long supplierId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.theftChance = theftChance;
        this.supplierName = supplierName;
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public double getTheftChance() {
        return theftChance;
    }

    public long getId() {
        return id;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }
}
