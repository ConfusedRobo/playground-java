package sessions.functional_programming;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        IntUnaryOperator operatorA = number -> number + 35;
        IntUnaryOperator operatorB = number -> number - 35;
        IntUnaryOperator chained = operatorA.andThen(operatorB);

        out.println(chained.applyAsInt(45));
        out.println(operatorA.applyAsInt(45));

        UnaryOperator<String> stringUnary = string -> string + " Successful";
        out.println(stringUnary.apply("Hello!"));
    }
}
