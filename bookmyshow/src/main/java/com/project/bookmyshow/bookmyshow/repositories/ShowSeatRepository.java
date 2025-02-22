package com.project.bookmyshow.bookmyshow.repositories;

import com.project.bookmyshow.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);

    ShowSeat save(ShowSeat showSeat);

    Optional<ShowSeat> findById(Long showSeatId);
}
