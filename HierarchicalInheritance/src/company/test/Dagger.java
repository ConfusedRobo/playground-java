package company.test;

public class Dagger extends Blade {
    private boolean conceal;

    public Dagger(String title, String style) {
        super(title, style);
    }

    public void setConceal(boolean conceal) {
        this.conceal = conceal;
    }

    public boolean isConcealed() {
        return conceal;
    }
}