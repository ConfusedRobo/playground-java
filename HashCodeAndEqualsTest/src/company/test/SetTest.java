package company.test;

import java.util.Objects;

/**
 * @author ConfusedRobo
 * Dated: 14-09-20
 * Do not modify.
 */
public class SetTest {
    private final String title;

    public SetTest(String title) {
        System.out.println("Constructor called.");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object object) {
        System.out.println("equals() called.");

        if (this == object) {
            return true;
        }

        if (!Objects.equals(object.getClass(), this.getClass())) {
            return false;
        }

        return this.title.equals(((SetTest) object).getTitle());
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode() called.");
        return this.title.hashCode();
    }
}