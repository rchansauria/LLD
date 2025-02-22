package com.project.bookmyshow.bookmyshow.dtos;

import com.project.bookmyshow.bookmyshow.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {

    private List<Long> showSeatIds;
    private String user_id;
}
