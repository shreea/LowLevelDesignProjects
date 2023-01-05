package CarRentalSystem.strategies.TotalBookingPriceForVehicle;

import com.lldParkingLot.lldParkingLot.models.Vehicle;

public interface TotalBookingPriceForVehicleStrategy {
    double getTotalBookingPriceForVehicle(String vehicleId);
}
