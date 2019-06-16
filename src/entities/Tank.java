package entities;

public class Tank {
    private long id;
    private double tankRadius;
    private double tankHeight;
    private double tankThickness;
    private double initialFillFactor;
    private double leakChance;
    private long stationId;

    public Tank(long id, double tankRadius, double tankHeight,
                double tankThickness, double initialFillFactor, double leakChance, long stationId) {
        this.id = id;
        this.tankRadius = tankRadius;
        this.tankHeight = tankHeight;
        this.tankThickness = tankThickness;
        this.initialFillFactor = initialFillFactor;
        this.leakChance = leakChance;
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
}
