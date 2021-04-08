package academy.learnprogramming;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Please enter your name");
//        String name = scanner.nextLine();
//        System.out.println("Hello " + name);
//        System.out.println("How old are you?");
//        int age = Integer.parseInt(scanner.nextLine());
//        System.out.println(name + " is " + age + " years old");
//        System.out.printf("%s is %d years old%n", name , age);

        //scanner.close();

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line1 = reader.readLine();
//        System.out.println(line1);

        String line = System.console().readLine();
        System.out.println(line);
    }

//    public static void main(String[] args) throws IOException {
//        int value = System.in.read();
//        System.out.println(value);
//    }
}
