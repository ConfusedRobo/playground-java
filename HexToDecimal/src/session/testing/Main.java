package session.testing;

public class Main {

    public static void main(String[] args) {
        System.out.println(hexToDec("-12143AB"));
    }

    public static int hexToDec(final String hexString) {
        StringBuilder hex = new StringBuilder(hexString);
        hex.reverse();

        int decimal = 0;
        boolean hasDash = false;

        for (int position = 0; position < hex.length(); position++) {
            if (hex.charAt(position) == '-') {
                hasDash = true;
            }

            if (position == hex.length() - 1) {
                if (hasDash) {
                    decimal *= -1;
                }
            }

            final char CURRENT = hex.charAt(position);
            if (Character.isAlphabetic(CURRENT)) {
                int coLetterVal;
                switch (CURRENT) {
                    case 'A':
                    case 'a':
                        coLetterVal = 10;
                        break;
                    case 'B':
                    case 'b':
                        coLetterVal = 11;
                        break;
                    case 'C':
                    case 'c':
                        coLetterVal = 12;
                        break;
                    case 'D':
                    case 'd':
                        coLetterVal = 13;
                        break;
                    case 'E':
                    case 'e':
                        coLetterVal = 14;
                        break;
                    case 'F':
                    case 'f':
                        coLetterVal = 15;
                        break;
                    default:
                        decimal = 0;
                        return decimal;
                }

                decimal += coLetterVal * (int) Math.pow(16, position);
                continue;
            }

            if (Character.isDigit(CURRENT)) {
                decimal += Integer.parseInt(CURRENT + "") * (int) Math.pow(16, position);
            }
        }

        return decimal;
    }

//    public static int hexToDec(final String hexString) {
//        return Integer.parseInt(hexString, 16);
//    }
}
