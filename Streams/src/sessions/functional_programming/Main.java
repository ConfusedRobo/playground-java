package sessions.functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        var bingoNumbers = Arrays.asList(
                "N40", "N36", "B12", "B61", "G53", "G49",
                "G60", "G50", "g64", "I26", "I17", "I29"
        );

        bingoNumbers.stream().map(String::toUpperCase)
                .filter(string -> string.startsWith("G"))
                .sorted().forEach(System.out::println);

        var list = new ArrayList<String>(5);
        bingoNumbers.stream().map(String::toUpperCase)
                .filter(string -> string.startsWith("G"))
                .sorted().forEach(list::add);

        out.println(list);
        out.println(bingoNumbers.stream().mapToInt(string -> Integer
                .parseInt(string.charAt(1) + "")).sum());

        var streamI = Stream.of("IO", "IN", "IC", "IR", "IV");
        var streamO = Stream.of("OP", "OK", "OM", "ON", "OR");
        List<String> concatIOList = Stream.concat(streamI, streamO).collect(Collectors.toList())
                .stream().sorted().collect(Collectors.toList());

        out.println(concatIOList);
        out.println(Stream.concat(Stream.of("IO", "IN", "IC", "IR", "IV"),
                Stream.of("OP", "OK", "OM", "ON", "OR")).count());
        out.println(Stream.concat(Stream.of("IO", "OM", "IN", "IC", "IR", "IV"),
                Stream.of("OP", "OK", "OM", "ON", "OR", "IN"))
                .distinct().peek(out::println).count());
    }
}
