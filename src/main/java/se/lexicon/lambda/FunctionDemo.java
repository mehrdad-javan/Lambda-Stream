package se.lexicon.lambda;

import java.text.DecimalFormat;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionDemo {

    public static void main(String[] args) {
        Function<String, String> convertStringToUppercase = (str) -> str.toUpperCase();
        UnaryOperator<String> convertStringToUppercaseS2 = (str) -> str.toUpperCase();

        System.out.println(convertStringToUppercase.apply("hello lambda!"));

        // 1234567.89 -> 1,234,567.89
        Function<Double, String> formatNumber = (number) -> {
            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
            return decimalFormat.format(number);
        };

        System.out.println(formatNumber.apply(1234567.89d));


        BiFunction<Integer, Integer, Integer> add = (n1, n2) -> n1 + n2;
        System.out.println(add.apply(10,20));
    }

}
