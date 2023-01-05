package CarRentalSystem.models;

import CarRentalSystem.models.enums.StoreStatus;
import com.lldParkingLot.lldParkingLot.models.Vehicle;

import java.util.List;

public class RentalLocation {
    String id;
    String name;
    Address address;
    StoreStatus storeStatus;
    List<Vehicle> vehicleList;
}
