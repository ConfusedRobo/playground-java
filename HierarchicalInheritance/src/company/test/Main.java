package company.test;

public class Main {

    public static void main(String[] args) {
        Sword sword = new Sword("Brynhildr", "German");
        Dagger dagger = new Dagger("Conniver's Kunai", "Japanese");
        System.out.println("Sword title: " + sword.getTitle());
        System.out.println("Sword style: " + sword.getStyle());
        if (sword.isSheathed()) {
            System.out.println(sword.getTitle() + " is currently sheathed.");
        }
        sword.setSheathe(false);
        System.out.println("*Zing*");
        if (!sword.isSheathed()) {
            System.out.println(sword.getTitle() + " is now un-sheathed.");
        }
        System.out.println("==================================================");
        System.out.println("Dagger title: " + dagger.getTitle());
        System.out.println("Dagger style: " + dagger.getStyle());
        if (dagger.isConcealed()) {
            System.out.println(dagger.getTitle() + " is currently hidden.");
        }
        dagger.setConceal(false);
        System.out.println("*Zing*");
        if (!dagger.isConcealed()) {
            System.out.println(dagger.getTitle() + " is now ready to taste blood.");
        }
    }
}
