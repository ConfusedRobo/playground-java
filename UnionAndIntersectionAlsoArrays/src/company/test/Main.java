package company.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add((int) Math.pow(i, 2));
            cubes.add((int) Math.pow(i, 3));
        }

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);

        System.out.println("There are " + squares.size() + " and " + cubes.size() + " cubes.");
        System.out.println("Union has " + union.size() + " elements.");

        System.out.println("Intersection has " + intersection.size() + " elements.");
        for (int i : intersection) {
            System.out.println("\t" + i + " is the square of " + (int) Math.sqrt(i));
            System.out.println("\t" + i + " is the cube of " + (int) Math.cbrt(i));
            System.out.println();
        }

        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        Set<String> words = new HashSet<>(Arrays.asList(arrayWords));

        for (String word : words) {
            System.out.println(word);
        }
        System.out.println();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};

        Set<String> nature = new HashSet<>(Arrays.asList(natureWords));
        Set<String> divine = new HashSet<>(Arrays.asList(divineWords));

        System.out.println("divine - nature");
        Set<String> excludeNature = new HashSet<>(divine);
        excludeNature.removeAll(nature);
        printSet(excludeNature);

        System.out.println("nature - divine");
        Set<String> excludeDivine = new HashSet<>(nature);
        excludeDivine.removeAll(divine);
        printSet(excludeDivine);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        System.out.println();
        if (nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature.");
        }

        if (nature.containsAll(intersectionTest)) {
            System.out.println("nature is a subset of intersectionTest.");
        }

        if (divine.containsAll(intersectionTest)) {
            System.out.println("divine is a subset of intersectionTest.");
        }
    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for (String word : set) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
