package CarRentalSystem.controllers;

import CarRentalSystem.models.dtos.VehicleDTO;
import com.lldParkingLot.lldParkingLot.models.Vehicle;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @GetMapping("/{vehicle-id}")
    public VehicleDTO getVehicleById(@PathVariable("vehicle-id") String id) {
        return null;
    }

    @PostMapping("/")
    public VehicleDTO createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return null;
    }

}
