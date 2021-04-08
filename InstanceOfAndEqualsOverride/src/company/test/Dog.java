package company.test;

/**
 * @author ConfusedRobo
 * Dated: 16-09-20
 * Do not modify.
 */
public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object instanceof Dog) {
            return this.getName().equals(((Dog) object).getName());
        }

        return false;
    }
}
