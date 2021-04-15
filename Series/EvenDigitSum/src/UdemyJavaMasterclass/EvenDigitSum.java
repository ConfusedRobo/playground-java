package UdemyJavaMasterclass;

public class EvenDigitSum {

    public static int getEvenDigitSum(int number) {

        int sumOfEvenDigits = 0;

        if (number < 0)
            return -1;

        for (;number != 0;number/=10)
            if (number % 10 % 2 == 0)
                sumOfEvenDigits += number % 10;

        return sumOfEvenDigits;

    }

}
