package application;
import model.entities.Resevation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int room = sc.nextInt();
            System.out.print("Check-in date(dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date(dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());
            Resevation reserv = new Resevation(checkOut, checkIn, room);

            System.out.println("Reservation: " + reserv);

            System.out.println("Enter data to update the reservation");

            System.out.print("Room number: ");
            room = sc.nextInt();
            System.out.print("Check-in date(dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date(dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserv.updateDate(checkIn,checkOut);
            System.out.println("Reservation: " + reserv);
        }
        catch (ParseException e){
          System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.print("Error in Reservation: "+ e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unxpected error");
        }

    sc.close();
    }
}