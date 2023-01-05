package CarRentalSystem.models.dtos;

import CarRentalSystem.models.Address;
import CarRentalSystem.models.enums.VehicleType;

import java.util.Date;

public class SearchVehicleDTO {
    Address currentLocation;
    Date from;
    Date to;
    VehicleType vehicleType;
}
