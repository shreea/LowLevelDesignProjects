package com.lldParkingLot.lldParkingLot.services;

import com.lldParkingLot.lldParkingLot.models.ParkingSlot;
import com.lldParkingLot.lldParkingLot.models.enums.ParkingSlotType;

public interface GetFreeParkingSlotStrategy {
    ParkingSlot getFreeParkingSlot(ParkingSlotType parkingSlotType);
}
