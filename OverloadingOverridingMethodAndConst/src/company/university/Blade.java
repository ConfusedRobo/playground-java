package company.university;

/**
 * @author ConfusedRobo
 * Dated: 22-09-20
 * Do not modify.
 */
public class Blade {
    private final int bladeDimension;

    public Blade(int bladeDimension) {
        this.bladeDimension = bladeDimension;
    }

    public Blade(int bladeLength, int bladeWidth) {
        this.bladeDimension = bladeLength * bladeWidth;
    }

    public int getBladeDimension() {
        return bladeDimension;
    }
}