package se.lexicon.lambda.practice;

@FunctionalInterface
public interface Conditional {
    boolean test(Product product);
}
