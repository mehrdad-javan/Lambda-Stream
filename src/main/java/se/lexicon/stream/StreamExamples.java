package se.lexicon.stream;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {


    public static void main(String[] args) {
        ex8();
    }


    // Terminal Operation: -> count()
    public static void ex1() {
        Stream<String> skills = Stream.of("Java", "C#", "Python", "C++");
        long count = skills.count();
        System.out.println(count); // 4
    }

    // Terminal Operation: -> max() & min()
    public static void ex2() {
        List<Integer> numbers = Arrays.asList(2, 100, 1, 12, 100000, 20000);
        //Comparator<Integer> comparatorWithLambda = (n1, n2) -> n1.compareTo(n2);
        //Comparator<Integer> comparatorWithMethodReference = Integer::compareTo;

        Optional<Integer> optionalMaxInteger = numbers.stream().max(Integer::compareTo);
        if (optionalMaxInteger.isPresent()) {
            System.out.println("Max Number is: " + optionalMaxInteger.get());
        } else {
            System.out.println("No Max number found.");
        }

        Optional<Integer> optionalMinInteger = numbers.stream().min(Integer::compareTo);
        if (optionalMinInteger.isPresent()) {
            System.out.println("Min Number is: " + optionalMinInteger.get());
        } else {
            System.out.println("No Min number found.");
        }

    }

    // Terminal Operation: findFirst()
    public static void ex3() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Bob", "David", "Eve");
        String foundName = names.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Element Not found."));
        System.out.println("foundName = " + foundName);

    }

    // Terminal Operation: allMatch(), anyMatch() & noneMatch()
    public static void ex4() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 12, 13);
        Predicate<Integer> isEven = n -> n % 2 == 0;
        boolean isAllMatch = numbers.stream().allMatch(isEven);
        System.out.println("isAllMatch = " + isAllMatch); // false

        boolean isAnyMatch = numbers.stream().anyMatch(isEven);
        System.out.println("isAnyMatch = " + isAnyMatch); // true

        boolean isNoneMatch = numbers.stream().noneMatch(isEven);
        System.out.println("isNoneMatch = " + isNoneMatch); // false
    }

    // Terminal Operation: collect()
    public static void ex5() {
        List<String> names = Arrays.asList("Niclas", "Erik", "Ulf", "Kent", "Fredrik", "Fredrik");
        //long count = names.stream().distinct().count();
        //System.out.println("count = " + count); // 5

        Set<String> strings = names.stream().collect(Collectors.toSet());
        System.out.println("strings = " + strings); // ?

    }


    // Intermediate Operation: filter()
    public static void ex6() {
        List<Integer> numbers = Arrays.asList(1, -7, 10, 26, -123, 32, 11, 7, 19);
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0) // Intermediate Operation
                .filter(n -> n > 0) // Intermediate Operation
                .collect(Collectors.toList()); // Terminal Operation
        System.out.println(oddNumbers);
    }

    // Intermediate Operation: skip() & limit()
    public static void ex7() {
        List<String> names = Arrays.asList("Erik", "Ulf", "Niclas", "Fredrik", "Marcus", "Kent");
        names.stream()
                .skip(3)
                .limit(2)
                .forEach(s -> System.out.println(s)); // Fredrik, Marcus
    }


    // Intermediate Operation: map() & sorted()
    public static void ex8() {
        List<Person> people = Arrays.asList(
                new Person("Alice", "Johnson", Gender.FEMALE, LocalDate.parse("1990-05-15"), true),
                new Person("Bob", "Smith", Gender.MALE, LocalDate.parse("1985-08-20"), false),
                new Person("Emily", "Davis", Gender.FEMALE, LocalDate.parse("1993-02-10"), true),
                new Person("John", "Doe", Gender.MALE, LocalDate.parse("1988-11-30"), false),
                new Person("Olivia", "Brown", Gender.FEMALE, LocalDate.parse("1987-04-25"), true),
                new Person("Michael", "Williams", Gender.MALE, LocalDate.parse("1991-09-05"), true),
                new Person("Sophia", "Martinez", Gender.FEMALE, LocalDate.parse("1989-07-12"), false),
                new Person("Daniel", "Johnson", Gender.MALE, LocalDate.parse("1995-03-18"), true),
                new Person("Ella", "Taylor", Gender.FEMALE, LocalDate.parse("1992-06-28"), false),
                new Person("William", "Anderson", Gender.MALE, LocalDate.parse("1986-12-03"), true),
                new Person("Ava", "Garcia", Gender.FEMALE, LocalDate.parse("1994-01-08"), false),
                new Person("Alexander", "Brown", Gender.MALE, LocalDate.parse("1984-10-17"), true),
                new Person("Charlotte", "Miller", Gender.FEMALE, LocalDate.parse("1990-08-22"), false),
                new Person("James", "Wilson", Gender.MALE, LocalDate.parse("1983-06-14"), true),
                new Person("Isabella", "Moore", Gender.FEMALE, LocalDate.parse("1988-04-07"), false)
        );

        Function<Person, String> extractPersonName = p -> p.getFirstName() + " " + p.getLastName();
        people.stream()
                .map(extractPersonName)
                .sorted()
                .forEach(name -> System.out.println(name));
                //.forEach(System.out::println);
        System.out.println("---------------------");
        people.stream()
                .sorted((p1, p2) -> p1.getBirthDate().compareTo(p2.getBirthDate()))
                //.sorted(Comparator.comparing(Person::getBirthDate))
                .forEach(p -> System.out.println(p));
    }
}
