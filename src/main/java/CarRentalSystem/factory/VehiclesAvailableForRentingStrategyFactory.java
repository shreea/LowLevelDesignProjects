package CarRentalSystem.factory;

import CarRentalSystem.models.enums.VehiclesAvailableForRentingStrategyType;
import CarRentalSystem.strategies.VehilceAvailableForRent.Impl.DefaultVehiclesAvailableForRentStrategyImpl;
import CarRentalSystem.strategies.VehilceAvailableForRent.Impl.VehicleAvailableForRentBasedOnLocationStrategyImpl;
import CarRentalSystem.strategies.VehilceAvailableForRent.VehiclesAvailableForRentingStrategy;

public class VehiclesAvailableForRentingStrategyFactory {

    public VehiclesAvailableForRentingStrategy getVehiclesAvailableForRentingStrategy(VehiclesAvailableForRentingStrategyType vehiclesAvailableForRentingStrategyType) {
        switch (vehiclesAvailableForRentingStrategyType) {
            case NEARBY:
                return new VehicleAvailableForRentBasedOnLocationStrategyImpl();
            default:
                return new DefaultVehiclesAvailableForRentStrategyImpl();
        }
    }
}
