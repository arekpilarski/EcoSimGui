package entities;

import java.util.List;

public class Station {
    private long id;
    private String name;
    private double fuelSalesFactor;
    private double climateOffset;
    private List<Supplier> suppliers;

    public Station(long id, String name, double fuelSalesFactor, double climateOffset, List<Supplier> suppliers) {
        this.id = id;
        this.name = name;
        this.fuelSalesFactor = fuelSalesFactor;
        this.climateOffset = climateOffset;
        this.suppliers = suppliers;
    }

    public String getName() {
        return name;
    }

    public double getFuelSalesFactor() {
        return fuelSalesFactor;
    }

    public double getClimateOffset() {
        return climateOffset;
    }

    public long getId() {
        return id;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }
}
