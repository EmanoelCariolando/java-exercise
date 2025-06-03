package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Resevation {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Integer roomNumber;
    Date checkIn;
    Date checkout;

    public Resevation(Date checkout, Date chekin, Integer roomNumber) {
        this.checkout = checkout;
        this.checkIn = chekin;
        this.roomNumber = roomNumber;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long Duration(){
      long diff =  checkout.getTime() - checkIn.getTime();
       return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }
    public String updateDate(Date checkIn, Date checkout){
        Date now = new Date();

        if(checkIn.before(now) || checkout.before(now)){
            return (" reservation dates for update must be future" + now);
        }
        else if (!checkout.after(checkIn)) {
           return  (" Check-out date must be after check-in date");
        }

        this.checkIn = checkIn;
        this.checkout = checkout;
        return null;
    }
    @Override
    public String toString(){
        return "Room  " + roomNumber + ", "+
                " check-in: " + sdf.format(checkIn) +
                "," + " check-out: " + sdf.format(checkout) +
                ", " + Duration() + " Nights ";
    }
}
