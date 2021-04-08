package sessions.data_structures;

import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        final var list = List.of(1, 2, 4, 2, 3, 5, 2, 5, 2, 5, 2, 5, 2);

        printList(list, number -> number != 5);
        out.println();

        printListInt(list, number -> number != 2);
        out.println();

        IntPredicate greaterThan1 = number -> number > 1;
        IntPredicate greaterThan2 = number -> number > 2;

        out.println("AND");
        out.println(greaterThan1.and(greaterThan2).test(1));
        out.println(greaterThan1.and(greaterThan2).test(2));
        out.println(greaterThan1.and(greaterThan2).test(3));
        out.println(greaterThan1.and(greaterThan2).test(-9));

        out.println("NEGATE");
        out.println(greaterThan1.negate().test(500));
        out.println(greaterThan2.negate().or(greaterThan1).test(500));

        var random = new Random();
        Supplier<Integer> supplier = () -> random.nextInt(1000);
        var castedSupplier = (Supplier<Integer>) () -> random.nextInt(1000);

        for (var index = 0; index < 10; index++) out.print(castedSupplier.get() + " ");
        out.println();
        for (var index = 0; index < 10; index++) out.print(supplier.get() + " ");
        out.println();
        for (var index = 0; index < 10; index++) out.print(random.nextInt(1000) + " ");
        out.println();
    }

    public static void printList(List<Integer> list, Predicate<Integer> predicate) {
        for (var current : list) if (predicate.test(current)) out.print(current + " ");
    }

    public static void printListInt(List<Integer> list, IntPredicate predicate) {
        for (var current : list) if (predicate.test(current)) out.print(current + " ");
    }
}
