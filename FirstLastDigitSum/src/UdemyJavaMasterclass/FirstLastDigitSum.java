package UdemyJavaMasterclass;

public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {

        int reverseOfDigits = 0;

        if (number < 0)
            return -1;

        for (int temp = number;temp != 0;temp/=10) {

            int remainder = temp % 10;
            reverseOfDigits = reverseOfDigits * 10 + remainder;

        }

        return reverseOfDigits % 10 + number % 10;

    }

}
