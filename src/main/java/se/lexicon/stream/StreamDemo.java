package se.lexicon.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo {

    public static void main(String[] args) {
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

        /*for (Person person : people){
            if (person.getBirthDate().isLeapYear()){
                System.out.println(person);
            }
        }
        System.out.println("--------------------");
        for (Person person : people){
            if (person.getGender() == Gender.FEMALE){
                System.out.println(person);
            }
        }*/

        Predicate<Person> isLeapYear = (p) -> p.getBirthDate().isLeapYear();
        Predicate<Person> isGenderFemale = (p) -> p.getGender() == Gender.FEMALE;
        Consumer<Person> printFullName = p -> System.out.println(p.getFirstName() + " " + p.getLastName());
        Consumer<Person> printSummary = p -> System.out.println(p.toString());

        //people.stream() // create stream
        //        .filter(isGenderFemale) // intermediate operation
        //        .filter(isLeapYear) // intermediate operation
        //        .forEach(printFullName); // terminal operation

        printPersonInfo(people, isLeapYear, printFullName);
        System.out.println("--------------");
        printPersonInfo(people, isLeapYear, printSummary);
        System.out.println("--------------");
        printPersonInfo(people, isGenderFemale, printSummary);


    }


    public static void printPersonInfo(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        people.stream() // create stream
                .filter(predicate) // intermediate operation
                .forEach(consumer); // terminal operation

    }


}
