package CabBookingSystem;
import java.util.*;

class Cab {
    int cabId;
    String driverName;
    boolean isAvailable;

    Cab(int cabId, String driverName) {
        this.cabId = cabId;
        this.driverName = driverName;
        this.isAvailable = true; // Initially cab is free
    }

    public Cab() {

    }
}
