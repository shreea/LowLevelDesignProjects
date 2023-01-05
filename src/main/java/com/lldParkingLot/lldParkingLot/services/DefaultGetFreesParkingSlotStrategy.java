package com.lldParkingLot.lldParkingLot.services;

import com.lldParkingLot.lldParkingLot.models.ParkingSlot;
import com.lldParkingLot.lldParkingLot.models.enums.ParkingSlotType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("default")
@Service
public class DefaultGetFreesParkingSlotStrategy implements GetFreeParkingSlotStrategy{

    @Override
    public ParkingSlot getFreeParkingSlot(ParkingSlotType parkingSlotType) {
        return null;
    }
}
