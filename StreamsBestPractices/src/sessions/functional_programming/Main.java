package sessions.functional_programming;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var john = new Employee("John Doe", 30);
        var jack = new Employee("Jack Jill", 22);
        var jane = new Employee("Jane Deer", 22);
        var snow = new Employee("Snow White", 27);

        var hr = new Department("Human Resources");
        hr.add(jack);
        hr.add(jane);
        hr.add(snow);

        var ac = new Department("Accounting");
        ac.add(john);

        var departments = new ArrayList<Department>(2);
        departments.add(hr);
        departments.add(ac);

        departments.stream().flatMap(department -> department.employees()
                .stream()).forEach(System.out::println);

        var sorted = new ArrayList<Integer>(5);
        departments.stream().flatMap(department -> department.employees()
                .stream()).forEach(employee -> sorted.add(employee.age()));
        sorted.forEach(item -> System.out.print(item + " "));
        System.out.println();

        var collectTest = departments.stream().flatMap(department -> department.employees()
                .stream()).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(collectTest);

        var streamString = Arrays.stream("Hello".split(""))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(streamString);

        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap(department -> department.employees().stream())
                .collect(Collectors.groupingBy(Employee::age));
        System.out.println(groupByAge);

        var save = new StringBuilder();
        departments.stream().flatMap(department -> department.employees()
                .stream()).reduce((a, b) -> a.age() < b.age() ? a : b)
                .ifPresent(save::append);
        System.out.println(save);

        departments.stream().flatMap(department -> department.employees()
                .stream()).reduce((a, b) -> a.age() < b.age() ? a : b)
                .ifPresent(System.out::println);
        departments.forEach(name -> System.out.println(name.name()));
        IntStream.rangeClosed(2, 100).forEach(item -> System.out.print(item + " "));
        System.out.print(java.util.stream.IntStream.rangeClosed(1, 6).reduce(1, (e1, e2) -> e1 * e2));

        var sum = new AtomicReference<>(0d);
        IntStream.rangeClosed(1, new Scanner(System.in).nextInt()).forEach(item -> {
            if (item % 2 == 1) sum.updateAndGet(variable -> variable + (double) item / (item + 1));
            else sum.updateAndGet(variable -> variable - (double) item / (item + 1));
        });
        System.out.println(sum);

        var result = java.util.stream.IntStream.rangeClosed(0, new java.util.Scanner(System.in).nextInt())
                                               .collect(StringBuilder::new, (builder, value) ->
                                                               builder.append((value & 1) == 0).append(" "),
                                                       StringBuilder::append);
        System.out.print(result);
    }
}
