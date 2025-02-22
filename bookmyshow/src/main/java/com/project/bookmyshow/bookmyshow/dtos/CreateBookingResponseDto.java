package com.project.bookmyshow.bookmyshow.dtos;

import com.project.bookmyshow.bookmyshow.models.BookingStatus;
import com.project.bookmyshow.bookmyshow.models.Bookings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {
    private Bookings booking;
    private BookingStatus status;
}
