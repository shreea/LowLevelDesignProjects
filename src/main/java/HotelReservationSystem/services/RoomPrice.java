package HotelReservationSystem.services;


import HotelReservationSystem.models.Room;
import HotelReservationSystem.models.enums.RoomType;

public class RoomPrice implements BookingPrice {

    @Override
    public double getBookingPrice(Room room) {
        //get current room charge for that typeof room
        return 0;
    }
}
