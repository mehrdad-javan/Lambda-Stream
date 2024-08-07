package se.lexicon.lambda.practice;

import java.util.ArrayList;
import java.util.List;

public class RunApp {


    public static void process(List<Product> products, Conditional condition, Action action) {
        for (Product product : products) {
            if (condition.test(product)) {
                action.execute(product);
            }
        }
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Iphone x", 1000.00, 1));
        productList.add(new Product("Surface Book 3", 2000.00, 20));
        productList.add(new Product("Iphone 6s", 100.00, 0));
        productList.add(new Product("Iphone 8", 150.00, 5));
        productList.add(new Product("Best", 120.00, 0));


        // todo: Print out all Products that have stock value of 0.
        //Action action = (p) -> System.out.println(p.toString());
        //Conditional conditional = (p) -> p.getStock() == 0;
        process(
                productList,
                (p) -> p.getStock() == 0,
                (p) -> System.out.println(p.toString()));
        System.out.println("----------------------------");
        // todo: Print out the productName of all the Products that starts with B.
        process(productList, (p) -> p.getProductName().startsWith("B"), p -> System.out.println(p));
        System.out.println("----------------------------");
        // todo: Print out all Products that have price above 100 AND lower than 150

        // todo: Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%


    }

}
