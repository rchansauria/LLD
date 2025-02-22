package com.project.bookmyshow.bookmyshow.services;

import com.project.bookmyshow.bookmyshow.exceptions.ShowSeatNotFoundException;
import com.project.bookmyshow.bookmyshow.exceptions.UserNotFoundException;
import com.project.bookmyshow.bookmyshow.models.*;
import com.project.bookmyshow.bookmyshow.repositories.BookingRepository;
import com.project.bookmyshow.bookmyshow.repositories.ShowSeatRepository;
import com.project.bookmyshow.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;
    private BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository, PriceCalculatorService priceCalculatorService, BookingRepository bookingRepository){
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
        this.bookingRepository = bookingRepository;
    }

    public Bookings createBooking(List<Long> showSeatIds, Long userId) throws UserNotFoundException, ShowSeatNotFoundException {

        Optional<Users> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User does not exists");
        }

        Users user = optionalUser.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat showSeat : showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotFoundException("Show seat with show id" + showSeat.getShows() + "and seat "+ showSeat.getSeats()+ "  not found");
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();

        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        // Create a booking object as status pending
        Bookings bookings = new Bookings();
        bookings.setUser(user);
        bookings.setShowSeatList(savedShowSeats);
        bookings.setBooking_status(BookingStatus.PENDING);
        bookings.setPayment_amount(priceCalculatorService.calculatePrice(savedShowSeats));

        bookingRepository.save(bookings);
        return bookings;
    }
}
 /*
        1. Fetech the user from User ID, if user not found throw an exception
        2. Fetch the showSeat object from the database
        3. Check If show seats are available
        4. If yes take a lock.
        5. If not throw an exception
        ----------Take a lock -------------
        6. Check the show seat status again
        7. Change the show seat status to BLOCKED
        ----------Release the lock-----------
        8. Create the booking to pending status
        9. Move to payment page

         */