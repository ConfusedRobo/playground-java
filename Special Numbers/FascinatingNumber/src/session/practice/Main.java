package session.practice;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("Entered number is" + (isFascinating(number) ? " fascinating." : "n't fascinating."));
        scanner.close();
    }

    public static boolean isFascinating(int number) {
        String string = ("" + number + number * 2 + number * 3 + 0);
        HashSet<Character> charactersSet = new HashSet<>();
        for (char character : string.toCharArray()) {
            charactersSet.add(character);
        }
        List<Character> characters = new LinkedList<>(charactersSet);
        Collections.sort(characters);

        for (char i = '0'; i <= '9'; i++) {
            if (i != characters.get(Integer.parseInt("" + i))) {
                return false;
            }
        }
        return true;
    }
}