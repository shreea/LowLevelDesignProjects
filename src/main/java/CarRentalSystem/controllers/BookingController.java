package CarRentalSystem.controllers;

import CarRentalSystem.exceptions.BookingCreationException;
import CarRentalSystem.models.Booking;
import CarRentalSystem.models.dtos.BookingRequestDTO;
import CarRentalSystem.models.dtos.BookingResponseDTO;
import CarRentalSystem.models.enums.BookingStatus;
import CarRentalSystem.services.BookingServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingServiceImpl bookingService;
    private final ModelMapper modelMapper;

    @PostMapping("/")
    public ResponseEntity<BookingResponseDTO> createBooking(BookingRequestDTO bookingRequestDTO) throws BookingCreationException {
        try {
            Booking booking = bookingService.createBooking(modelMapper.map(bookingRequestDTO, Booking.class));
            return ResponseEntity.ok(modelMapper.map(booking, BookingResponseDTO.class));
        } catch (Exception e) {
            throw new BookingCreationException("error in creating a new booking", e);
        }
    }

    @PatchMapping("/status/{booking-id}")
    public boolean changeBookingStatus(@PathParam("booking-id") String bookingId, BookingStatus bookingStatus) {
        return bookingService.changeBookingStatus(bookingId, bookingStatus);
    }
}
