package application;

import application.util.Verification;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Integer> list1 = Arrays.asList(1,2,3,5,10);

        Stream<Integer> st1 = list1.stream();
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 =  Stream.of("Maria","João", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0,x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));
        


    }
}