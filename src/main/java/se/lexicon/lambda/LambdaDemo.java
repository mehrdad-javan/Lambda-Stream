package se.lexicon.lambda;

public class LambdaDemo {

    static DoStringStuff concatString = (str1, str2) -> str1.concat(" ").concat(str2);
    static DoStringStuff getBiggestString = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;

    static DoubleOperator addition = (n1, n2) -> n1 + n2;
    static DoubleOperator subtraction = (n1, n2) -> n1 - n2;
    static DoubleOperator multiplication = (n1, n2) -> n1 * n2;
    static DoubleOperator division = (n1, n2) -> n1 / n2;

    public static String doStringStuff(String s1, String s2, DoStringStuff operation) {
        return operation.operate(s1, s2);
    }

    public static Double calcOperator(Double n1, Double n2, DoubleOperator operator) {
        return operator.apply(n1, n2);
    }


    public static void main(String[] args) {

        // String operate(String s1, String s2);
        //DoStringStuff concatString = (str1, str2) -> str1.concat(" ").concat(str2);
        //DoStringStuff getBiggestString = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;

        System.out.println(concatString.operate("Hello", "Lambda!"));
        System.out.println(getBiggestString.operate("Hello", "Lambda!"));

        System.out.println(doStringStuff("Hello", "Lambda!", concatString));
        System.out.println(doStringStuff("Hello", "Lambda!", getBiggestString));

        System.out.println(calcOperator(20d,3d, addition));
        System.out.println(calcOperator(20d,3d, subtraction));
        System.out.println(calcOperator(20d,3d, multiplication));
        System.out.println(calcOperator(20d,3d, division));


        // boolean testInt(int n);
        Conditional isPositive = number -> number > 0;
        System.out.println(isPositive.testInt(100));
        System.out.println(isPositive.testInt(-100));

    }

}
