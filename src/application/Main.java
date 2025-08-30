package application;

import application.entities.Persons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.print("Type your path: ");
        String path = sc.nextLine();

        System.out.print("Enter salary: ");
        Double orderSalary = sc.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Persons> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                list.add(new Persons(fields[0],fields[1],Double.parseDouble(fields[2])));
                line = br.readLine();

            }

            Comparator<String> comp = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> emails = list.stream()
                    .filter(p -> p.getSalary() > orderSalary)
                    .map(p -> p.getEmail())
                    .sorted(comp)
                    .toList();

            System.out.println("Email of people whose salary is more than 2000.00: ");
            emails.forEach(System.out::println);

            Double sum = list.stream()
                    .filter(p -> p.getName().charAt(0) == 'M')
                    .map(p -> p.getSalary())
                    .reduce(0.0, (x,y) -> x + y);


            System.out.print("Sum of salary of people whose name starts with 'M': " + sum);
        }



        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}