package UdemyJavaMasterclass;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {

        int reverseOfDigits = 0;

        for (int temp = number;temp != 0;temp/=10) {

            int remainder = temp % 10;
            reverseOfDigits = reverseOfDigits * 10 + remainder;

        }

        return number == reverseOfDigits;

    }

}
