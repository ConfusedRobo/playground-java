package company.test;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("tester.txt");
            writer.write("Following are 10 the even numbers:-\n");
            for (int i = 1; i < 11; i++) {
                writer.append(((Integer) getNumber(i, true)).toString()).append("\n");
            }
            writer.close();
        } catch (IOException exception) {
            System.out.println("Exception has been handled.");
            exception.printStackTrace();
        }
    }

    /**
     * Returns an Integer value that will be an even number if isEven parameter
     * is set to true and odd if it's set to false. Also, it will return 0 if
     * negative values or, 0 is entered.
     *
     * @param term is exactly as the name implies. It specifies the term number
     *             for the even/odd number. It starts from 1 to INT_MAX.
     *             For example, if the term number is three of even number then
     *             it'll give out 6.
     *             Note: Must not be negative or, zero.
     * @param isEven specifies if the returned number will be odd or, even. That
     *              is, even if it is set to true and odd otherwise.
     * @return An Integer value that may be an odd or, and even number. Or, 0 if
     * it is an invalid (term) value.
     */
    public static int getNumber(int term, boolean isEven) {
        if (term < 1) {
            return 0;
        }

        int count = 0;
        if (!isEven){
            for (int i = 0; true; i++) {
                if (i % 2 != 0) {
                    ++count;
                    if (count == term) {
                        return i;
                    }
                }
            }
        } else {
            for (int i = 0; true; i++) {
                if (i % 2 == 0) {
                    if (count == term) {
                        return i;
                    }
                    ++count;
                }
            }
        }
    }
}