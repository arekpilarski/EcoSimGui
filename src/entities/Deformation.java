package entities;
/**
 * Deformation class stores provided user input data about deformation.
 */
public class Deformation {
    private long id;

    /**
     * Height at which the deformation is located.
     */
    private double height;

    /**
     * Value in m^3 defining fuel level difference.
     */
    private double value;

    /**
     * Id of the tank that has the deformation.
     */
    private long tankId;

    public Deformation(long id, double height, double value, long tankId) {
        this.id = id;
        this.height = height;
        this.value = value;
        this.tankId = tankId;
    }

    public long getId() {
        return id;
    }

    public double getHeight() {
        return height;
    }

    public double getValue() {
        return value;
    }

    public long getTankId() {
        return tankId;
    }
}
