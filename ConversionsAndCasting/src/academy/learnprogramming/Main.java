package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

        double poundVal = 12;
        double onePoundToKg = 0.45359237;
        double conversionToKg = poundVal * onePoundToKg;

        double underscoreExample = 12_000_000.45_000;

        System.out.println(conversionToKg);
        System.out.println(underscoreExample);

    }
}
