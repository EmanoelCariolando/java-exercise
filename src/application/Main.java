package application;
import model.entities.Resevation;

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

        System.out.print("Room number: ");
        int room = sc.nextInt();
        System.out.print("Check-in date(dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date(dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        Resevation reserv = new Resevation(checkOut, checkIn, room);

        if (!checkOut.after(checkIn)) {
            System.out.print("Error in reservation: Check-out date must be after check-in date");
        } else {
            System.out.println("Reservation: " + reserv);
        }

        System.out.println("Enter data to update the reservation");

        System.out.print("Room number: ");
        room = sc.nextInt();
        System.out.print("Check-in date(dd/mm/yyyy): ");
        checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date(dd/mm/yyyy): ");
        checkOut = sdf.parse(sc.next());
        
    Date now = new Date();
    if(checkIn.before(now) || checkOut.before(now)){
        System.out.println("Error in reservation: reservation dates for update must be future" + now);
    } else if (!checkOut.after(checkIn)) {
        System.out.println("Error in reservation: Check-out date must be after check-in date");
    }
    else {
        reserv.updateDate(checkIn,checkOut);
        System.out.println("Reservation: " + reserv);
    }
    sc.close();
    }
}