package application;

import application.util.UpperCaseName;

import javax.swing.*;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 50.00));
        list.add(new Product("PC", 30.00));
        list.add(new Product("Play", 40.00));
        list.add(new Product("Controller", 60.00));


        List<String> newList = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

        newList.forEach(System.out::println);




    }
}