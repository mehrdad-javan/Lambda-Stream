package se.lexicon.practice;

@FunctionalInterface
public interface Action {
    void execute(Product product);
}
