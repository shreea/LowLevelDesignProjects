package CarRentalSystem.models.dtos;

import CarRentalSystem.models.AddOns;

import java.util.Date;
import java.util.List;

public class BookingResponseDTO {
    String bookingId;
    Date from;
    Date to;
    String vehicleId;
    List<AddOns> addOnsList;
    double totalPrice;
}
