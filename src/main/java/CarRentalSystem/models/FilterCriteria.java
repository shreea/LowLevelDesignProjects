package CarRentalSystem.models;

import CarRentalSystem.models.enums.VehicleColor;
import CarRentalSystem.models.enums.VehicleType;
import lombok.Data;

@Data
public class FilterCriteria {
    Location location;
    VehicleColor color;
    VehicleType vehicleType;
    int mileage;
}
