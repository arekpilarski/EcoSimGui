package logic;

import entities.Deformation;
import entities.Station;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.io.File;
import java.util.Objects;

/**
 * Driver class is the main class of the application. It acts as a container for the main method.
 */
public class Driver {

    /**
     * Main method of the application
     */
    public static void run(List<Deformation> deformations,
                            List<entities.Driver> drivers,
                            List<Station> stations,
                            List<entities.Supplier> suppliers,
                            List<entities.Tank> tanks,
                           String outputDirectory) {

        System.out.println("Deformations: " + deformations.size());
        System.out.println("Drivers: " + drivers.size());
        System.out.println("Stations: " + stations.size());
        System.out.println("Suppliers: " + suppliers.size());
        System.out.println("Tanks: " + tanks.size());
        System.out.println("Station suppliers: " + stations.get(0).getSuppliers().size());

        // Generate suppliers and drivers
        List<Supplier> supplierList = new ArrayList<>();
        for (entities.Supplier supplier : suppliers) {
            List<entities.Driver> stationDrivers = new ArrayList<>();
            for(entities.Driver driver : drivers) {
                if (driver.getSupplierId() == supplier.getId()) {
                    stationDrivers.add(driver);
                }
            }
            supplierList.add(new Supplier(supplier, stationDrivers));
        }

        // Generate fuel stations
        List<FuelStation> stationList = new ArrayList<>();
        for (Station station : stations) {

            // Generate temperature data
            TemperatureGenerator generator = new TemperatureGenerator();
            TemperatureData data = generator.generateAnnualData(2000, 2.5, station.getClimateOffset());

            // Generate tanks
            List<Tank> stationTanks = new ArrayList<>();
            int tankIterator = 0;
            for (entities.Tank tank : tanks) {
                if (tank.getStationId() == station.getId()) {

                    // Get deformations for the tank
                    List<Tank.Deformation> tankDeformations = new ArrayList<>();
                    for (Deformation deformation : deformations) {
                        if (deformation.getTankId() == tank.getId()) {
                            tankDeformations.add(new Tank.Deformation(deformation));
                        }
                    }

                    stationTanks.add(new Tank(tank, station.getName(), tankIterator++, data, tankDeformations));
                }
            }

            // Add suppliers
            List<Supplier> stationSuppliers = new ArrayList<>();
            for (entities.Supplier supplier : station.getSuppliers()) {
                for (Supplier generatedSupplier : supplierList) {
                    if (Objects.equals(supplier.getName(), generatedSupplier.getName())) {
                        stationSuppliers.add(generatedSupplier);
                        break;
                    }
                }
            }
            stationList.add(new FuelStation(station, stationTanks, stationSuppliers));
            System.out.println("Generated station suppliers list: " + stationSuppliers.size());
            System.out.println("Generated station tanks list: " + stationTanks.size());
        }


        System.out.println("Generated suppliers list: " + supplierList.size());
        System.out.println("Generated stations list: " + stationList.size());

        // Iterate through the data
        MyCalendar currentDate = new MyCalendar();
        currentDate.set(2000, 1, 1);
        for(int i = 0; i < currentDate.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {

            // Iterate through each pair of fuel station and temperature
            for (FuelStation station : stationList) {

                // Update the fuel station and store current fuel data
                station.update(currentDate);
            }
            currentDate.nextDay();
        }

        // End simulation
        for (FuelStation station : stationList) {
            for(Tank tank : station.getTanks()) {
                tank.writeData(outputDirectory);
            }
        }
    }
}
