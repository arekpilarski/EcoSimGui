package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Station class stores provided user input data about station.
 */
public class Station {
    private long id;

    /**
     * Name of the fuel station.
     */
    private String name;

    /**
     * Factor that determines how much fuel will be sold daily on avarage.
     */
    private double fuelSalesFactor;

    /**
     * Factor that determines temperature that surrounds the station.
     */
    private double climateOffset;

    /**
     * String containing concatenated names of suppliers for the station.
     */
    private String supplierNames;

    /**
     * List of suppliers for the station.
     */
    private List<Supplier> suppliers;

    public Station(long id, String name, double fuelSalesFactor, double climateOffset, List<Supplier> suppliers) {
        this.id = id;
        this.name = name;
        this.fuelSalesFactor = fuelSalesFactor;
        this.climateOffset = climateOffset;
        this.suppliers = new ArrayList<>();
        this.suppliers.addAll(suppliers);

        StringBuilder supplierNames= new StringBuilder();
        suppliers.stream().forEach(supplier -> supplierNames.append(supplier.getName()).append(","));
        this.supplierNames = supplierNames.deleteCharAt(supplierNames.lastIndexOf(",")).toString();
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

    public String getSupplierNames() {
        return supplierNames;
    }
}
