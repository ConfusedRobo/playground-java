package company.test;

public class Main {

    public static void main(String[] args) {
        Parker magicPen = new Parker(100, true, true);

        System.out.println("Pen name: Parker Magic pen");
        System.out.println("Pen capacity: " + magicPen.getInkAmount());
        System.out.println();

        magicPen.write("Hello world!");
        magicPen.write("Hi! Everyone.");
        System.out.println();

        if (magicPen.hasInk()) {
            System.out.println("Magic pen has ink.");
        }

        if (magicPen.hasRefill()) {
            System.out.println("Magic pen already has a refill.");
        }
        System.out.println();

        magicPen.setInk(false);
        magicPen.write("Testing...");

        magicPen.setRefill(false);
        magicPen.write("Testing...");
    }
}