package CarRentalSystem.models;

import CarRentalSystem.models.enums.BookingStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Booking {
    String bookingId;
    Date from;
    Date to;
    String vehicleId;
    List<AddOns> addOnsList;
    double totalPrice;
    BookingStatus bookingStatus;
    Payment payment;
}
