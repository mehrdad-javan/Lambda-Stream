package se.lexicon;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<String> sessionIdGenerator = () -> UUID.randomUUID().toString();
        System.out.println(sessionIdGenerator.get());

        System.out.println(takeDecimalInput.get());
    }


    public static Supplier<Double> takeDecimalInput = () -> {
        Double number;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a Number: ");
                number = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Number is not valid!");
            }
        }
        return number;
    };
}
