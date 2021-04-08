package company.test;

public class Main {

    public static void main(String[] args) {
        Katana katana = new Katana("Yamato", "Japanese, Kodachi");
        System.out.println("Sword name: " + katana.getTitle());
        System.out.println("Sword origin, style: " + katana.getStyle());
        System.out.println();
        if (katana.isSheathed()) {
            System.out.println("Katana is sleeping.");
        }
        katana.setSheathe(false);
        System.out.println("*Zing*");
        if (!katana.isSheathed()) {
            System.out.println(katana.getTitle() + " has awoken.");
            katana.useKatana();
            katana.useKatana();
            katana.useKatana();
            katana.useKatana();
            katana.useKatana();
            katana.useKatana();
            katana.useKatana();
            katana.useKatana();
            katana.useKatana();
            katana.setSheathe(true);
            katana.useKatana();
        }
    }
}
