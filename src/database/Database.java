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

    public static void addDriver(Driver driver) {
        drivers.add(driver);
        DRIVERS_INDEX++;
    }

    public static void addStation(Station station) {
        stations.add(station);
        STATIONS_INDEX++;
    }

    public static void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
        SUPPLIERS_INDEX++;
    }

    public static void addTank(Tank tank) {
        tanks.add(tank);
        TANKS_INDEX++;
    }

    public static void addDeformation(Deformation deformation) {
        deformations.add(deformation);
        DEFORMATIONS_INDEX++;
    }

    public static void removeDeformation(Deformation deformation) {
        deformations.remove(deformation);

    }
    public static void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    public static void removeStation(Station station) {
        stations.remove(station);
    }

    public static void removeSupplier(Supplier supplier) {
        suppliers.remove(supplier);
    }

    public static void removeTank(Tank tank) {
        tanks.remove(tank);
    }

    public static Station getStationByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny().get();
    }

    public static Supplier getSupplierByName(String name) {
        return suppliers.stream()
                .filter(supplier -> supplier.getName().equals(name))
                .findAny().get();
    }
}
