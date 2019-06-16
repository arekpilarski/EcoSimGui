package entities;

public class Tank {
    private long id;
    private double tankVolume;
    private double tankRadius;
    private double tankHeight;
    private double tankThickness;
    private double leakChance;
    private long stationId;

    public Tank(long id, double tankVolume,
                double tankRadius, double tankHeight,
                double tankThickness, double leakChance, long stationId) {
        this.id = id;
        this.tankVolume = tankVolume;
        this.tankRadius = tankRadius;
        this.tankHeight = tankHeight;
        this.tankThickness = tankThickness;
        this.leakChance = leakChance;
        this.stationId = stationId;
    }

    public long getId() {
        return id;
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public double getTankRadius() {
        return tankRadius;
    }

    public double getTankHeight() {
        return tankHeight;
    }

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
