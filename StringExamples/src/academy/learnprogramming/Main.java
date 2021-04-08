package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        //                             1         2         3
        //                   0123456789012345678901234567890123456
        String courseName = "Learn Java for Beginners Crash Course";

        int position;

        position = indexOfIgnoreCase(courseName, " j");
        System.out.println(position);
    }

    private static int indexOfIgnoreCase(String text, String searchText) {
        String textLowerCase = text.toLowerCase();
        String searchTextLowerCase = searchText.toLowerCase();
        return textLowerCase.indexOf(searchTextLowerCase);
    }
}
