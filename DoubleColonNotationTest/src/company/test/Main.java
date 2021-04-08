package company.test;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Dummy dummy = new Dummy();
        Function<Integer, Integer> testA = dummy::getTestNum;

        int output = testA.apply(2);
        System.out.print(output);
    }
}
