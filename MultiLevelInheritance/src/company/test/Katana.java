package company.test;

public class Katana extends Sword {
    private int durability;
    public Katana(String title, String style) {
        super(title, style);
        durability = 100;
    }
    public void useKatana() {
        if (!super.isSheathed()) {
            if (durability <= 0) {
                System.out.println("*Break*");
                System.out.println("Your blade is no longer usable.");
            } else if (durability <= 50) {
                System.out.println("*Slash*");
                System.out.println("Your blade needs repairing.");
                durability -= 20;
            } else {
                System.out.println("*Slash*");
                durability -= 10;
            }
        } else {
            System.out.println("Cannot use! Sword is sheathed.");
        }
    }
}