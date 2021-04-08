package sessions.functional_programming;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var names = new String[]{
                "Jon Doe", "Ellie Lock", "Eliza Jenkins",
                "Ryder Bridgett", "Jack Henning", "Rick Brown"
        };

        Function<String, String> lastName = name -> name.split(" ")[1];
        Function<String, String> uppercase = name -> name.toUpperCase(Locale.ROOT);

        var chainedFirst = lastName.andThen(uppercase);
        var chainedLast = uppercase.compose(lastName);

        for (var current : names) out.println(chainedLast.apply(current));
        out.println("============");
        for (var current : names) out.println(chainedFirst.apply(current));
        out.println("============");
        for (var current : names) out.println(lastName.apply(current));

        Function<Integer, Integer> fibonacciRecursion = new Function<>() {
            @Override
            public Integer apply(Integer term) {
                return term == 0 || term == 1 ? term : apply(term - 1) + apply(term - 2);
            }
        };

        Function<Integer, Integer> fibonacciArray = term -> {
            final var array = new int[term + 1];
            array[0] = 0;
            array[1] = 1;

            for (var index = 2; index <= term; index++) array[index] = array[index - 1] + array[index - 2];
            return array[term];
        };

        out.println("============");
        out.println("55th Fibonacci term: " + fibonacci(10, fibonacciRecursion));
        out.println("55th Fibonacci term: " + fibonacci(10, fibonacciArray));

        Function<String, String> firstName = name -> name.split(" ")[0];
        BiFunction<String, String, String> fullName = (first, last) -> first + " " + last;
        BiFunction<String, String, String> biChained = fullName.andThen(uppercase);

        out.println("============");
        for (var current : names) out.println(biChained.apply(firstName.apply(current), lastName.apply(current)));
    }

    public static int fibonacci(int term, Function<Integer, Integer> algorithm) {
        return algorithm.apply(term);
    }
}
