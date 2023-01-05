package com.lldParkingLot.lldParkingLot.services;

import com.lldParkingLot.lldParkingLot.models.ParkingSlot;
import com.lldParkingLot.lldParkingLot.models.enums.ParkingSlotType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ParkingSlotService {
    private final GetFreeParkingSlotStrategy getFreeParkingSlotStrategy;

    public ParkingSlotService(@Qualifier("default") GetFreeParkingSlotStrategy getFreeParkingSlotStrategy) {
        this.getFreeParkingSlotStrategy = getFreeParkingSlotStrategy;
    }

    public ParkingSlot getAvailableParkingSlotForType(ParkingSlotType parkingSlotType) {
        return getFreeParkingSlotStrategy.getFreeParkingSlot(parkingSlotType);
    }

    public boolean freeAParkingSlot(int parkingSlotId) {
        return true;
    }

    public boolean reserveAParkingSlot(int parkingSlotId) {
        return true;
    }
}
