package application;

import application.util.ProductPredicate;

import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 50.00));
        list.add(new Product("PC", 300.00));
        list.add(new Product("TV", 400.00));
        list.add(new Product("TV", 40.00));

        list.removeIf(new ProductPredicate());

        for (Product p : list){
            System.out.println(p);
        }


    }
}