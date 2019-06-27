package database;

import entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Database class that stores all user input data in memory,
 */
public class Database {
    /**
     * List of drivers.
     */
    public static List<Driver> drivers = new ArrayList<>();

    /**
     * List of suppliers.
     */
    public static List<Supplier> suppliers = new ArrayList<>();

    /**
     * List of stations.
     */
    public static List<Station> stations = new ArrayList<>();

    /**
     * List of tanks.
     */
    public static List<Tank> tanks = new ArrayList<>();

    /**
     * List of deformations.
     */
    public static List<Deformation> deformations = new ArrayList<>();

    public static long DRIVERS_INDEX = 1;
    public static long SUPPLIERS_INDEX = 1;
    public static long STATIONS_INDEX = 1;
    public static long TANKS_INDEX = 1;
    public static long DEFORMATIONS_INDEX = 1;

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

    /**
     * Adds driver to database.
     */
    public static void addDriver(Driver driver) {
        drivers.add(driver);
        DRIVERS_INDEX++;
    }

    /**
     * Adds station to database.
     */
    public static void addStation(Station station) {
        stations.add(station);
        STATIONS_INDEX++;
    }

    /**
     * Adds supplier to database.
     */
    public static void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
        SUPPLIERS_INDEX++;
    }

    /**
     * Adds tanks to database.
     */
    public static void addTank(Tank tank) {
        tanks.add(tank);
        TANKS_INDEX++;
    }

    /**
     * Adds deformation to database.
     */
    public static void addDeformation(Deformation deformation) {
        deformations.add(deformation);
        DEFORMATIONS_INDEX++;
    }

    /**
     * Removes deformation from database.
     */
    public static void removeDeformation(Deformation deformation) {
        deformations.remove(deformation);

    }

    /**
     * Removes driver from database.
     */
    public static void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    /**
     * Removes station from database.
     */
    public static void removeStation(Station station) {
        stations.remove(station);
    }

    /**
     * Removes supplier from database.
     */
    public static void removeSupplier(Supplier supplier) {
        suppliers.remove(supplier);
    }

    /**
     * Removes tank from database.
     */
    public static void removeTank(Tank tank) {
        tanks.remove(tank);
    }

    /**
     * Returns station object of given name.
     */
    public static Station getStationByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny().get();
    }

    /**
     * Returns supplier object of given name.
     */
    public static Supplier getSupplierByName(String name) {
        return suppliers.stream()
                .filter(supplier -> supplier.getName().equals(name))
                .findAny().get();
    }
}
