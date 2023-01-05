package CarRentalSystem.strategies.VehilceAvailableForRent;

import CarRentalSystem.models.Vehicle;
import CarRentalSystem.models.dtos.SearchVehicleDTO;

import java.util.List;

public interface VehiclesAvailableForRentingStrategy {
    List<Vehicle> getVehiclesAvailableForRent(SearchVehicleDTO rentRequestDTO);
}
