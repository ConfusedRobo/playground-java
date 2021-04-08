package company.confused.myseries;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Series.nSum(i) + " " + Series.factorial(i) + " " + Series.fibonacci(i));
        }
    }
}
