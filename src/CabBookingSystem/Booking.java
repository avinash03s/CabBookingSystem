package CabBookingSystem;
import java.util.*;

class Booking extends Cab {
    int bookingId;
    String customerName;
    Cab cab;

    Booking(int bookingId, String customerName, Cab cab) {
        super();
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.cab = cab;
        cab.isAvailable = false; // once booked, cab becomes unavailable
    }
}