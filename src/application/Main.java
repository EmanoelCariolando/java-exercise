package application;

import application.util.Verification;

import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 50.00));
        list.add(new Product("PC", 30.00));
        list.add(new Product("Play", 40.00));
        list.add(new Product("Tablet", 60.00));
        list.add(new Product("Console", 100.00));
        list.add(new Product("Control", 80.00));

        System.out.print("Type one letter of your product for sum: ");
        char letter = sc.next().charAt(0);

        Verification veri = new Verification();

        double sum = veri.filtered(list, p -> p.getName().charAt(0) == letter );

        System.out.println("All sums: " + sum);










    }
}