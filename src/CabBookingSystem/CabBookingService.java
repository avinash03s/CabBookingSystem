package CabBookingSystem;

import java.util.*;

public class CabBookingService extends Booking {
    static List<Cab> cabList = new ArrayList<>();
    static List<Booking> bookingList = new ArrayList<>();
    static int bookingCounter = 1;
  //  static int bookingCounter=2;
    CabBookingService(int bookingId, String customerName, Cab cab) {//constructor
        super(bookingId, customerName, cab);
    }

    public static void main(String[] args) {
        // Add some cabs
        cabList.add(new Cab(1, "Rajesh"));
        cabList.add(new Cab(2, "Suresh"));
        cabList.add(new Cab(3, "Mahesh"));
        cabList.add(new Cab(4,"Kamlesh"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--- Cab Booking Service ---");
            System.out.println("1. Book Cab");
            System.out.println("2. View Bookings");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    bookCab(name);
                    break;
                case 2:
                    viewBookings();
                    break;
                case 3:
                    System.out.println("Thanks for using our service!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void bookCab(String customerName) {
        for (Cab cab : cabList) {
            if (cab.isAvailable) {
                Booking booking = new Booking(bookingCounter++, customerName, cab);
                bookingList.add(booking);
                System.out.println("Booking Successful! Cab " + cab.cabId +
                        " with driver " + cab.driverName + " is booked.");
                return;
            }
        }
        System.out.println("No cabs available right now.");
    }

    static void viewBookings() {
        if (bookingList.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        for (Booking booking : bookingList) {
            System.out.println("Booking ID: " + booking.bookingId +
                    ", Customer: " + booking.customerName +
                    ", Driver: " + booking.cab.driverName);
        }
    }
}
