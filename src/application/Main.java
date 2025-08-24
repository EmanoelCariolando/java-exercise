package application;

import application.util.ProductPredicate;

import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 55.00));
        list.add(new Product("PC", 30.00));
        list.add(new Product("Play", 40.00));
        list.add(new Product("Controller", 60.00));

        double perce = 1.1;

        list.forEach(p -> p.setPrice(p.getPrice() * perce) );

        list.forEach(System.out::print);




    }
}