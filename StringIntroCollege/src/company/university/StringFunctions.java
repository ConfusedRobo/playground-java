package company.university;

/**
 * @author Confused Robo
 * Dated: 29-09-2020
 * Do not modify.
 */
public class StringFunctions {
    private final String string;

    public StringFunctions(String string) {
        this.string = string;
    }

    public String getReverse() {
        return (new StringBuilder(string)).reverse().toString();
    }

    public String concatenateString(String target) {
        return string.concat(target);
    }

    public int compareString(String target) {
        return string.compareTo(target);
    }

    public String toCapital() {
        return string.toUpperCase();
    }

    public String toSmall() {
        return string.toLowerCase();
    }
}
