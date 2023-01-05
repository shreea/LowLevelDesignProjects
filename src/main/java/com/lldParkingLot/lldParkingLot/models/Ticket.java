package com.lldParkingLot.lldParkingLot.models;

import lombok.Data;

import java.util.Date;

@Data
public class Ticket {
    private String id;
    private int parkingSlotId;
    private Date inTime;
    private Date outTime;
    private String paymentId;
}
