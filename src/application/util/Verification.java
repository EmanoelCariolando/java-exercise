package application.util;

import application.Product;

import java.util.List;
import java.util.function.Predicate;

public class Verification {
    public double filtered(List<Product> list, Predicate<Product> criteria){
        double sums = 0.0;
        for (Product p: list){
            if (criteria.test(p)){
              sums += p.getPrice();
            }
        }
        return sums;

    }

}
