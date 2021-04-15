package utilities.csvoperations;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            CSVReader test = new CSVReader("recipes.csv");
            System.out.println(test.readFull());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}