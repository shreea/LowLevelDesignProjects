package CarRentalSystem.repository;

import CarRentalSystem.models.Booking;
import CarRentalSystem.models.enums.BookingStatus;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {
    public Booking getBookingById(String bookingId) {
        return new Booking();
    }

    public boolean updateStatusForBooking(String bookingId, BookingStatus bookingStatus) {
        return true;
    }
}
