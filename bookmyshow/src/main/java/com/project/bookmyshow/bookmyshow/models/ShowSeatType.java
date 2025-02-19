package com.project.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{

    @ManyToOne
    private Shows shows;

    @ManyToOne
    private SeatType seatType;

    private Double price;
}
