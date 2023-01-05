package com.lldParkingLot.lldParkingLot.models;

import lombok.Data;

@Data
public class Vehicle {
    private String vehicleNumber;
    private String licenseNumber;
    private Ticket ticket;
}
