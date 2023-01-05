package com.lldParkingLot.lldParkingLot.controllers;

import com.lldParkingLot.lldParkingLot.models.Ticket;
import com.lldParkingLot.lldParkingLot.models.dtos.VehicleDTO;
import com.lldParkingLot.lldParkingLot.services.EntranceGateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrance-gate")
public class EntranceGateController {

    private EntranceGateService entranceGateService;

    @GetMapping("/book")
    public Ticket bookFreeSlot (VehicleDTO vehicleDTO) {
        return null;
    }


}
