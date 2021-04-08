package sessions.functional_programming;

public class Employee {
    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int age() {
        return age;
    }

    @Override
    public String toString() {
        return name;
    }
}
