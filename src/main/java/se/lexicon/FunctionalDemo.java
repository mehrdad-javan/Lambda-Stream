package se.lexicon;


public class FunctionalDemo {

    static DoStringStuff concatString = new DoStringStuff() {
        @Override
        public String operate(String s1, String s2) {
            return s1.concat(" ").concat(s2);
        }
    };

    static DoStringStuff getBiggestString = new DoStringStuff() {
        @Override
        public String operate(String s1, String s2) {
            return s1.length() > s2.length() ? s1 : s2;
        }
    };

    static DoubleOperator addition = new DoubleOperator() {
        @Override
        public Double apply(Double a, Double b) {
            return a + b;
        }
    };

    static DoubleOperator subtraction = new DoubleOperator() {
        @Override
        public Double apply(Double a, Double b) {
            return a - b;
        }
    };


    public static String doStringStuff(String s1, String s2, DoStringStuff operation) {
        return operation.operate(s1, s2);
    }

    public static Double calcOperator(Double n1, Double n2, DoubleOperator operator) {
        return operator.apply(n1, n2);
    }


    public static void main(String[] args) {

        /*DoStringStuff concatString = new DoStringStuff() {
            @Override
            public String operate(String s1, String s2) {
                return s1.concat(" ").concat(s2);
            }
        };

        DoStringStuff getBiggestString = new DoStringStuff() {
            @Override
            public String operate(String s1, String s2) {
                return s1.length() > s2.length() ? s1 : s2;
            }
        };*/


        System.out.println(concatString.operate("Hello", "Functional Programming!"));
        System.out.println(getBiggestString.operate("Hello", "Functional Programming!"));

        System.out.println(addition.apply(2d, 3d)); // 5
        System.out.println(subtraction.apply(2d, 3d)); // -1

        System.out.println(doStringStuff("Hello", "Functional Programming! ", concatString));
        System.out.println(doStringStuff("Hello", "Functional Programming! ", getBiggestString));

        System.out.println(calcOperator(5d,2d, addition));
        System.out.println(calcOperator(5d,2d, subtraction));

    }// main

}
