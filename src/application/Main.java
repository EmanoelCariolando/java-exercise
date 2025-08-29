package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);



        System.out.print("Type your path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Product> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                list.add(new Product(fields[0],Double.parseDouble(fields[1])));
                line = br.readLine();

            }

            double media = list.stream()
                    .map(p -> p.getPrice())
                    .reduce(0.0, (x,y) -> x + y) / list.size();

            System.out.println("Avarage price: " + String.format("%.2f",media));

            Comparator<String> comp = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> names = list.stream()
                    .filter(p -> p.getPrice() < media)
                    .map(p -> p.getName())
                    .sorted(comp.reversed())
                    .toList();

            names.forEach(System.out::println);
        }


        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}