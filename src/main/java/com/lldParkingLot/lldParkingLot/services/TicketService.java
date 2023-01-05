package com.lldParkingLot.lldParkingLot.services;

import com.lldParkingLot.lldParkingLot.models.ParkingSlot;
import com.lldParkingLot.lldParkingLot.models.Ticket;
import com.lldParkingLot.lldParkingLot.models.dtos.VehicleDTO;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TicketService {

    public Ticket generateTicket(VehicleDTO vehicleDTO, Date entryTime, int parkingSlotId) {
        Ticket ticket = new Ticket();
        return ticket;
    }
}
