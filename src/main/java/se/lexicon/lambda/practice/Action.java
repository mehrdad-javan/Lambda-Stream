package se.lexicon.lambda.practice;

@FunctionalInterface
public interface Action {
    void execute(Product product);
}
