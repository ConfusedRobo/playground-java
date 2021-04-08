package company.university;

public class Main {

    public static void main(String[] args) {
        Sword excalibur = new Sword(12);
        excalibur.setStyle("Excalibur, European");

        Sword kodachi = new Sword(5, 3);
        kodachi.setStyle("Kodachi", "Japanese");

        System.out.println(excalibur + "\n" + kodachi);
    }
}