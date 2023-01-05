package HotelReservationSystem.services;

import HotelReservationSystem.models.Room;
import HotelReservationSystem.models.enums.RoomType;

public class ExtraMattressCharge extends RoomPrice{
    private double mattressCharge;
    int numberOfExtraMattress;

    public ExtraMattressCharge(BookingPrice bookingPrice, double mattressCharge, int numberOfExtraMattress) {
        this.mattressCharge = mattressCharge;
        this.numberOfExtraMattress = numberOfExtraMattress;
    }

    @Override
    public double getBookingPrice(Room room) {
        return super.getBookingPrice(room) + mattressCharge * numberOfExtraMattress;
    }
}
