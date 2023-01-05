package HotelReservationSystem.models;

import HotelReservationSystem.models.enums.RoomType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {
    String id;
    RoomType roomType;
    double price;
}
