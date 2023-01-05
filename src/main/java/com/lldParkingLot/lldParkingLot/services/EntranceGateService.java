package com.lldParkingLot.lldParkingLot.services;

import com.lldParkingLot.lldParkingLot.models.ParkingSlot;
import com.lldParkingLot.lldParkingLot.models.Ticket;
import com.lldParkingLot.lldParkingLot.models.dtos.VehicleDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@Service
public class EntranceGateService {
    @Autowired
    private ParkingSlotService parkingSlotService;
    @Autowired
    private TicketService ticketService;

    public Ticket bookFreeSlot(VehicleDTO vehicleDTO) {
        ParkingSlot parkingSlot = parkingSlotService.getAvailableParkingSlotForType(vehicleDTO.getRequiredParkingSlotType());
        parkingSlotService.reserveAParkingSlot(parkingSlot.getId());
        return ticketService.generateTicket(vehicleDTO, new Date(), parkingSlot.getId());
    }

}
