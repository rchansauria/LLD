package com.project.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private Shows shows;

    @ManyToOne
    private Seats seats;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}
