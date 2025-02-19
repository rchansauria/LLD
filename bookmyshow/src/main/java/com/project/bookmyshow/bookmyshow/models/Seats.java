package com.project.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seats extends BaseModel {

    private String seat_number;

    @ManyToOne
    private SeatType seatType;

    private int row;
    private int column;
}
