package CarRentalSystem.controllers;

import CarRentalSystem.models.enums.StoreStatus;
import CarRentalSystem.models.dtos.RentalLocationDTO;
import CarRentalSystem.models.dtos.RentalLocationRequest;
import CarRentalSystem.models.dtos.VehicleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental-location")
public class RentalLocationController {

    @PostMapping("/")
    public RentalLocationDTO createRentalLocation(@RequestBody RentalLocationRequest rentalLocationRequest) {
        //
        return null;
    }

    @PatchMapping("/status")
    public boolean changeRentalLocationStatus(@RequestParam StoreStatus storeStatus) {
        return true;
    }

    @PostMapping("/vehicles")
    public boolean addVehiclesToRentalLocation(@RequestBody List<VehicleDTO> vehicleDTOList) {
        return true;
    }

    @GetMapping("/{rental-location/vehicles}")
    public List<VehicleDTO> getVehiclesInRentalLocation(String id) {
        return null;
    }

}
