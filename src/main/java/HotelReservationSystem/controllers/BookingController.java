package HotelReservationSystem.controllers;

import HotelReservationSystem.models.Booking;
import HotelReservationSystem.models.Room;
import HotelReservationSystem.models.dtos.BookingDTO;
import HotelReservationSystem.models.dtos.BookingRequest;
import HotelReservationSystem.services.BookingPrice;
import HotelReservationSystem.services.ExtraMattressCharge;
import HotelReservationSystem.services.RoomPrice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static HotelReservationSystem.models.enums.RoomType.DELUXE;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @PostMapping("/")
    public BookingDTO createNewBooking(BookingRequest bookingRequest) {
        BookingPrice bookingPrice = new ExtraMattressCharge(new RoomPrice(), 5, 2);
        Booking.builder().bookingId("123").checkInDate(new Date()).checkoutDate(new Date())
                .roomsList(List.of(Room.builder().roomType(DELUXE).price(10).build()))
                .bookingPrice(bookingPrice);

        return new BookingDTO();
    }
}
