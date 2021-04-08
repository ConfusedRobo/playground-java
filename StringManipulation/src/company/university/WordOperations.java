package company.university;

/**
 * @author Rajat Biswas
 * Dated:23-09-2020
 * Do not modify.
 */
public class WordOperations {
    public String reverse(String word) {
        StringBuilder reverseWord = new StringBuilder();
        for (int i = word.length() - 1; i > -1; i--) {
            reverseWord.append(word.charAt(i));
        }

        return reverseWord.toString();
    }

    public boolean isPalindrome(String word) {
        return reverse(word).equals(word);
    }
}
