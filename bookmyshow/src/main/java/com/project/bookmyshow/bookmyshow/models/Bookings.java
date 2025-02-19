package com.project.bookmyshow.bookmyshow.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Bookings extends BaseModel {
    @ManyToOne
    private Users user;

    private String booking_number;
    private Date booking_date;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus booking_status;

    @OneToMany
    private List<Payments> paymentTypeList;

    private Double payment_amount;

    @OneToMany
    private List<ShowSeat> showSeatList;
}
