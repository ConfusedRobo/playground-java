package company.test;

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