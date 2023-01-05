package CarRentalSystem.factory;

import CarRentalSystem.models.enums.TotalBookingPriceForVehicleStrategyType;
import CarRentalSystem.strategies.TotalBookingPriceForVehicle.Impl.DefaultTotalBookingPriceForVehicleStrategyImpl;
import CarRentalSystem.strategies.TotalBookingPriceForVehicle.TotalBookingPriceForVehicleStrategy;

public class TotalBookingPriceFactory {
    public TotalBookingPriceForVehicleStrategy getTotalBookingPriceForVehicleStrategy (TotalBookingPriceForVehicleStrategyType totalBookingPriceForVehicleStrategyType) {
        switch (totalBookingPriceForVehicleStrategyType) {
            default:
                return new DefaultTotalBookingPriceForVehicleStrategyImpl();
        }
    }
}
