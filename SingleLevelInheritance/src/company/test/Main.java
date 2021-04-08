package company.test;

public class Main {

    public static void main(String[] args) {
        Sword sword = new Sword("Excalibur", "European");

        System.out.println("I am Arthur Pendragon the rightful owner of " + sword.getTitle() + ".");
        System.out.println("This is a " + sword.getStyle() + " holy blade.");
        System.out.println();

        if (sword.isSheathed()) {
            System.out.println("Excalibur is currently sheathed.");
        }

        sword.setSheathe(false);
        System.out.println("Zing!");

        if (!sword.isSheathed()) {
            System.out.println("Excalibur is now un-sheathed.");
        }
    }
}