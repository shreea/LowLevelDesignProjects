package CarRentalSystem.models;

import CarRentalSystem.models.enums.VehicleType;
import lombok.Data;

@Data
public class Vehicle {
    String id;
    String licenseNumber;
    VehicleType vehicleType;
    double price;
}
