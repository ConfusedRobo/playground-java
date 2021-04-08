package sessions.functional_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {

    private final String name;
    private final List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> employees() {
        return Collections.unmodifiableList(employees);
    }

    public String name() {
        return name;
    }
}
