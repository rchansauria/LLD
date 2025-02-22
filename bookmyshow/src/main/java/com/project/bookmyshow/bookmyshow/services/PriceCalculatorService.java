package com.project.bookmyshow.bookmyshow.services;

import com.project.bookmyshow.bookmyshow.models.ShowSeat;
import com.project.bookmyshow.bookmyshow.models.ShowSeatType;
import com.project.bookmyshow.bookmyshow.repositories.ShowSeatRepository;
import com.project.bookmyshow.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceCalculatorService {

    private final ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculatePrice(List<ShowSeat> showSeatList) {
        double price = 0;
        List<ShowSeatType> showSeatTypeList = showSeatTypeRepository.findAllByShow(showSeatList.get(0).getShows());
        for (ShowSeat showSeat : showSeatList) {
            for (ShowSeatType showSeatType : showSeatTypeList) {
                if (showSeat.getSeats().getSeatType().equals(showSeatType)) {
                    price += showSeatType.getPrice();
                    break;
                }
            }
        }
        return price;
    }
}
