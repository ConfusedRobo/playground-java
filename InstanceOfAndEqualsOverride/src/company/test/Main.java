package company.test;

public class Main {

    public static void main(String[] args) {
        Dog test1 = new Dog("Jin");
        Labrador test2 = new Labrador("Jin");

        System.out.print(test1.equals(test2) + " " + test2.equals(test1));
    }
}