package entities;

public class Driver {
    private long id;
    private String name;
    private double age;
    private double theftChance;
    private String supplierName;
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
