package entities;

/**
 * Tank class stores provided user input data about tank.
 */
public class Tank {
    private long id;

    /**
     * Factor that tells how much fuel should there be in the tank at the moment of creation.
     */
    private double initialFillFactor;

    /**
     * Radius of the tank's base.
     */
    private double tankRadius;

    /**
     * Height of the tank.
     */
    private double tankHeight;

    /**
     * Thickness of the tank's wall.
     */
    private double tankThickness;

    /**
     * Chance for the leak to appear during one day.
     */
    private double leakChance;

    /**
     * Name of the station the tank belongs to.
     */
    private String stationName;

    /**
     * Id of the station the tank belongs to.
     */
    private long stationId;

    public Tank(long id, double initialFillFactor,
                double tankRadius, double tankHeight,
                double tankThickness, double leakChance,
                long stationId, String stationName) {
        this.id = id;
        this.initialFillFactor = initialFillFactor;
        this.tankRadius = tankRadius;
        this.tankHeight = tankHeight;
        this.tankThickness = tankThickness;
        this.initialFillFactor = initialFillFactor;
        this.leakChance = leakChance;
        this.stationName = stationName;
        this.stationId = stationId;
    }

    public long getId() {
        return id;
    }

    public double getTankRadius() {
        return tankRadius;
    }

    public double getTankHeight() {
        return tankHeight;
    }

    public double getInitialFillFactor() { return initialFillFactor; }

    public double getTankThickness() {
        return tankThickness;
    }

    public double getLeakChance() {
        return leakChance;
    }

    public long getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }
}
