package database;

import entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Driver> drivers = new ArrayList<>();
    public static List<Supplier> suppliers = new ArrayList<>();
    public static List<Station> stations = new ArrayList<>();
    public static List<Tank> tanks = new ArrayList<>();
    public static List<Deformation> deformations = new ArrayList<>();

    public static ObservableList<Driver> getDrivers() {
        return FXCollections.observableArrayList(drivers);
    }
    public static ObservableList<Station> getStations() {
        return FXCollections.observableArrayList(stations);
    }
    public static ObservableList<Supplier> getSuppliers() {
        return FXCollections.observableArrayList(suppliers);
    }
    public static ObservableList<Tank> getTanks() {
        return FXCollections.observableArrayList(tanks);
    }
    public static ObservableList<Deformation> getDeformations() {
        return FXCollections.observableArrayList(deformations);
    }

    public static void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public static void addTank(Tank tank) {
        tanks.add(tank);
    }

    public static void addDeformation(Deformation deformation) {
        deformations.add(deformation);
    }


}
