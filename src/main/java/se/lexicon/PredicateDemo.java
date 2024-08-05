package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Integer> isPositive = num -> num > 0;

        List<Integer> numbers = new ArrayList<>();
        for (int i = -10; i <= 30; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);


        System.out.println(filterNumbers(numbers, isPositive));
        System.out.println(filterNumbers(numbers, num -> num % 2 == 0));
        System.out.println(filterNumbers(numbers, num -> num % 2 != 0));


    }


    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> filteredList = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                filteredList.add(number);
            }
        }
        return filteredList;
    }
}
