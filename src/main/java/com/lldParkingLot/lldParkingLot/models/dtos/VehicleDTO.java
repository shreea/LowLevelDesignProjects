package com.lldParkingLot.lldParkingLot.models.dtos;

import com.lldParkingLot.lldParkingLot.models.enums.ParkingSlotType;
import com.lldParkingLot.lldParkingLot.models.enums.VehicleType;
import lombok.Data;

@Data
public class VehicleDTO {
    ParkingSlotType requiredParkingSlotType;

}
