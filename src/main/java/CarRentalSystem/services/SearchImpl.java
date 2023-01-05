package CarRentalSystem.services;

import CarRentalSystem.factory.VehiclesAvailableForRentingStrategyFactory;
import CarRentalSystem.models.FilterCriteria;
import CarRentalSystem.models.Vehicle;
import CarRentalSystem.models.dtos.SearchVehicleDTO;
import CarRentalSystem.models.enums.VehiclesAvailableForRentingStrategyType;
import CarRentalSystem.strategies.VehilceAvailableForRent.VehiclesAvailableForRentingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
public class SearchImpl {

    private final VehiclesAvailableForRentingStrategyFactory vehiclesAvailableForRentingStrategyFactory;

    public List<Vehicle> searchAvailableVehicles(SearchVehicleDTO rentRequestDTO, FilterCriteria filterCriteria) {
        if(filterCriteria.getLocation() != null){

        }
        VehiclesAvailableForRentingStrategy vehiclesAvailableForRentingStrategy = vehiclesAvailableForRentingStrategyFactory.getVehiclesAvailableForRentingStrategy(VehiclesAvailableForRentingStrategyType.NEARBY);

        return vehiclesAvailableForRentingStrategy.getVehiclesAvailableForRent(rentRequestDTO);
    }
}
