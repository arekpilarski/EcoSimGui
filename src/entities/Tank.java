package entities;

public class Tank {
    private long id;
    private double initialFillFactor;
    private double tankRadius;
    private double tankHeight;
    private double tankThickness;
    private double leakChance;
    private String stationName;
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
