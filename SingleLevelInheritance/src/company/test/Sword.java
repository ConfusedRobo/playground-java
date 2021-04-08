package company.test;

/**
 * @author ConfusedRobo
 * Created by dev in 02-09-2020
 * Do not modify.
 */
public class Sword extends Blade {
    private boolean sheathe;

    public Sword(String title, String style) {
        super(title, style);
        sheathe = true;
    }

    public void setSheathe(boolean sheathe) {
        this.sheathe = sheathe;
    }

    public boolean isSheathed() {
        return sheathe;
    }
}