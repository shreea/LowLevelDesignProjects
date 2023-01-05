package HotelReservationSystem.models;

import HotelReservationSystem.services.BookingPrice;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class Booking {
    private String bookingId;
    private Date checkInDate;
    private Date checkoutDate;
    private double totalPrice;
    private List<Room> roomsList;
    private BookingPrice bookingPrice;

    public double getTotalPrice() {
        return roomsList.stream()
                .map(room -> bookingPrice.getBookingPrice(room))
                .reduce((double) 0, Double::sum);
    }

}
