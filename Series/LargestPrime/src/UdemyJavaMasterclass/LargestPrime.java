package UdemyJavaMasterclass;

public class LargestPrime {

    public static int getLargestPrime(int number) {

        if (number < 2)
            return -1;

        int temp = 0;

        for (int factorCounter = 2; factorCounter <= number; ++factorCounter)
            for (; number % factorCounter == 0; number /= factorCounter)
                temp = factorCounter;

        return temp;

    }
//        Note: Factor tree concept is implemented in this problem.
//              First loop is for iteration only.
//              Second loop is for filtering the factors
//              After, i (first loop counter) meets all the constraints
//              implemented by the loop it assigns that
//              value (var. i) to temp variable and then it changes
//              the value of the number variable to number/i


}