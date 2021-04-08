package UdemyJavaMasterclass;

public class IntEqualityPrinter {

    public static void printEqual(int varA, int varB, int varC) {

        System.out.println(varA < 0 || varB < 0 || varC < 0 ? "Invalid Value" :
                varA == varB && varA == varC ? "All numbers are equal" :
                        varA != varB && varA != varC && varB != varC ? "All numbers are different"
                                : "Neither all are equal or different");

    }

}
