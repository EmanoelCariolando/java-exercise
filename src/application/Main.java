package application;


import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Date (DD/MM/YYYY): ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);
        System.out.print("Value of contract: ");
        Double value = sc.nextDouble();

        Contract obj = new Contract(number,date, value);

        System.out.print("Enter the installments: ");
        Integer n = sc.nextInt();


        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(obj, n);

        for (Installment installment : obj.getInstallments()){
            System.out.println(installment);
        }


    }
}