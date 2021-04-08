package company.test;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<SetTest> planets = new HashSet<>();
        planets.add(new SetTest("Earth"));
        planets.add(new SetTest("Mars"));
        planets.add(new SetTest("Saturn"));
        planets.add(new SetTest("Jupiter"));
        planets.add(new SetTest("Venus"));
        planets.add(new SetTest("Neptune"));
        planets.add(new SetTest("Uranus"));
        planets.add(new SetTest("Mercury"));
        planets.add(new SetTest("Pluto"));
        planets.add(new SetTest("UB-313"));

        //Duplicate - HashCode test
        planets.add(new SetTest("Uranus"));

        System.out.println("Entered planets:-");
        for (SetTest planet : planets) {
            System.out.println("\t-> " + planet.getTitle());
        }
    }
}