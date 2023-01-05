package com.lldParkingLot.lldParkingLot.models;

import com.lldParkingLot.lldParkingLot.models.enums.ParkingSlotType;
import lombok.Data;

@Data
public class ParkingSlot {
    private int id;
    private ParkingSlotType parkingSlotType;

}
