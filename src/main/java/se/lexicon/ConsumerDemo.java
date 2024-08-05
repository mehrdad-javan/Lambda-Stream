package se.lexicon;

import se.lexicon.practice.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<String> printMessage = (msg) -> System.out.println(msg);
        printMessage.accept("Hello Consumer Interface!");


        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Iphone x", 1000.00, 1));
        productList.add(new Product("Surface Book 3", 2000.00, 20));
        productList.add(new Product("Iphone 6s", 100.00, 0));
        productList.add(new Product("Iphone 8", 150.00, 5));
        productList.add(new Product("Best", 120.00, 0));

        Consumer<Product> printProductName = (p) -> System.out.println(p.getProductName().toUpperCase());
        Consumer<Product> printProductPrice = (p) -> System.out.println(p.getPrice());

        /*for (Product product: productList){
            printProductPrice.accept(product);
        }*/

        productList.forEach(printProductName);

    }

}
