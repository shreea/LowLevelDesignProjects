package CarRentalSystem.strategies.VehilceAvailableForRent.Impl;

import CarRentalSystem.models.Vehicle;
import CarRentalSystem.models.dtos.SearchVehicleDTO;
import CarRentalSystem.strategies.VehilceAvailableForRent.VehiclesAvailableForRentingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Qualifier("default")
public class DefaultVehiclesAvailableForRentStrategyImpl implements VehiclesAvailableForRentingStrategy {

    @Override
    public List<Vehicle> getVehiclesAvailableForRent(SearchVehicleDTO searchVehicleDTO) {
        return null;
    }
}
