package CarRentalSystem.strategies.VehilceAvailableForRent.Impl;

import CarRentalSystem.models.Vehicle;
import CarRentalSystem.models.dtos.SearchVehicleDTO;
import CarRentalSystem.strategies.VehilceAvailableForRent.VehiclesAvailableForRentingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Qualifier("nearby")
public class VehicleAvailableForRentBasedOnLocationStrategyImpl implements VehiclesAvailableForRentingStrategy {

    @Override
    public List<Vehicle> getVehiclesAvailableForRent(SearchVehicleDTO rentRequestDTO) {
        return null;
    }
}
