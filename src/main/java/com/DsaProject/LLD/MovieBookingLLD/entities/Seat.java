package com.DsaProject.LLD.MovieBookingLLD.entities;

import com.DsaProject.LLD.MovieBookingLLD.enums.SeatStatus;
import com.DsaProject.LLD.MovieBookingLLD.enums.SeatType;

public class Seat {
    String id;
    int row;
    int col;
    SeatType seatType;
    SeatStatus status;

    public Seat(String id, int row, int col, SeatType seatType)
    {
        this.id =id;
        this.row = row;
        this.col = col;
        this.seatType = seatType;
        this.status = SeatStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public SeatType getSeatType()
    {
        return seatType;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
