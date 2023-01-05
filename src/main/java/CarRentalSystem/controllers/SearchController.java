package CarRentalSystem.controllers;

import CarRentalSystem.models.FilterCriteria;
import CarRentalSystem.models.dtos.SearchVehicleDTO;
import CarRentalSystem.models.dtos.VehicleSummaryDTO;
import CarRentalSystem.services.SearchImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class SearchController {

    private final SearchImpl searchImpl;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public List<VehicleSummaryDTO> searchAvailableVehicles(@RequestBody SearchVehicleDTO rentRequestDTO, @RequestBody FilterCriteria filterCriteria) {
        return searchImpl.searchAvailableVehicles(rentRequestDTO, filterCriteria)
                .stream().map(vehicle -> modelMapper.map(vehicle, VehicleSummaryDTO.class))
                .collect(Collectors.toList());
    }
}
