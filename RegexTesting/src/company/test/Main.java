package company.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I'm a string. Yes, I am.\n\tI am username LadiesMan217.";

        System.out.println(string.replaceAll("\\.", "*"));
        System.out.println(string.replaceAll("...i", "*"));

        System.out.println(string.replaceAll("^I", "*"));
        System.out.println(string.replaceAll("^s", "*"));

        System.out.println(string.replaceAll("[aes]", "*"));
        System.out.println(string.replaceAll("[a'][m]", "*"));

        System.out.println(string.replaceAll("[^aes]", "*"));
        System.out.println(string.replaceAll("[0-9]", "*"));
        System.out.println(string.replaceAll("[^0-9]", "*"));

        System.out.println(string.replaceAll("[0-9a]", "*"));
        System.out.println(string.replaceAll("[^0-9a]", "*"));
        System.out.println(string.replaceAll("^[A-Z]", "*"));
        System.out.println(string.replaceAll("[0-9A-Za-z]", "*"));
        System.out.println(string.replaceAll("[^0-9A-Za-z]", "*"));

        System.out.println(string.replaceAll("(?i)[a-z]", "*"));

        System.out.println(string.replaceAll("\\s", "*"));
        System.out.println(string.replaceAll("\\S", "*"));
        System.out.println(string.replaceAll("\\w", "*"));
        System.out.println(string.replaceAll("\\W", "*"));
        System.out.println(string.replaceAll("\\b", "*"));
        System.out.println(string.replaceAll("\\B", "*"));

        System.out.println(string.replaceAll("\t", "*"));
        System.out.println(string.replaceAll("\n", "*"));

        String word = "abcDeeeeeqqqqQabcdual";

        System.out.println(word.replaceAll("^abcDe+q{4}", "*"));
        System.out.println(word.replaceAll("^abcDe{3}", "*"));
        System.out.println(word.replaceAll("^abcDe+", "*"));
        System.out.println(word.replaceAll("^abcDe*", "*"));

        String wordMod = word.replaceAll("e+", "");

        System.out.println(wordMod);
        System.out.println(wordMod.replaceAll("^abcD*", "*"));

        String stringA = "abcDeeeeeeZtytr45";
        System.out.println(stringA.replaceAll("^abcDe{4,6}", "*"));
        System.out.println(stringA.replaceAll("^abcDe{7,9}", "*"));

        StringBuilder htmlSnippet = new StringBuilder("<h1>This is the main heading</h1>");
        htmlSnippet.append("<h2>This is the sub-heading about a certain topic.</h2>");
        htmlSnippet.append("<p>This is a paragraph about something.</p>");
        htmlSnippet.append("<p>This is another paragraph about the same thing.</p>");
        htmlSnippet.append("<h2>This is a subheading about another subtopic.</h2>");
        htmlSnippet.append("<p>This is a paragraph about something else.</p>");

        String charSequenceWrong = "<h2>";
        Pattern patternA = Pattern.compile(charSequenceWrong);
        Matcher matcherA = patternA.matcher(htmlSnippet);
        System.out.println(matcherA.matches());

        String charSequenceRight = ".*<h2>.*";
        Pattern patternB = Pattern.compile(charSequenceRight);
        Matcher matcherB = patternB.matcher(htmlSnippet);
        System.out.println(matcherB.matches());

        System.out.println(charSequenceRight + "\t" + charSequenceWrong);

        String newPattern = "<h2>";
        Pattern pattern = Pattern.compile(newPattern);
        Matcher matcher = pattern.matcher(htmlSnippet);
        System.out.println(matcher.matches());
        matcher.reset();

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String groupPattern = "(<h2>.*?</h2>)";
        Pattern patternGroup = Pattern.compile(groupPattern);
        Matcher matcherGroup = patternGroup.matcher(htmlSnippet);
        System.out.println(matcherGroup.matches());
        matcherGroup.reset();

        while (matcherGroup.find()) {
            System.out.println("Occurrence: " + matcherGroup.group());
        }

        String filterPattern = "(<h2>)(.+?)(</h2>)";
        Pattern patternForFilter = Pattern.compile(filterPattern);
        Matcher matcherForFilter = patternForFilter.matcher(htmlSnippet);
        System.out.println(matcherForFilter.matches());
        matcherForFilter.reset();

        while (matcherForFilter.find()) {
            System.out.println("Occurrence: " + matcherForFilter.group(2));
        }
    }
}