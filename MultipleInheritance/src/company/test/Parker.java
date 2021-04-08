package company.test;

/**
 * @author ConfusedRobo
 * Created by dev in 02-09-2020
 * Do not modify.
 */
public class Parker implements Pen, Ink {
    private final int refillCapacity;
    private boolean refill;
    private boolean ink;

    public Parker(int refillCapacity, boolean refill, boolean ink) {
        this.refillCapacity = refillCapacity;
        this.refill = refill;
        this.ink = ink;
    }

    @Override
    public int getInkAmount() {
        return refillCapacity;
    }

    @Override
    public boolean hasInk() {
        return refill;
    }

    @Override
    public void write(String text) {
        if (!refill) {
            System.out.println("Unable to write. Insert a refill first.");
        } else {
            if (!ink) {
                System.out.println("Unable to write. Refill has ran out of ink.");
            } else {
                System.out.println("You have written: " + text);
            }
        }
    }

    @Override
    public boolean hasRefill() {
        return refill;
    }

    @Override
    public void setInk(boolean ink) {
        this.ink = ink;
    }

    @Override
    public void setRefill(boolean refill) {
        this.refill = refill;
    }
}
