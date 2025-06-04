package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
        System.out.print("Enter account data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        double withdrawLimit = 300;
        System.out.println("This is your withdraw limit: "+ withdrawLimit);
        Account account = new Account(number,holder,initialBalance,withdrawLimit);

        System.out.print("Enter amount to be withdrawn: ");
        double value = sc.nextDouble();
        account.withdraw(value);

        System.out.println("New Balance: " + account);

        }
        catch (DomainException e){
            System.out.println("Invalid data: " + e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Invalid!!!");
        }

        sc.close();
    }
}