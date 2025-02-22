package com.project.bookmyshow.bookmyshow.repositories;

import com.project.bookmyshow.bookmyshow.models.ShowSeatType;
import com.project.bookmyshow.bookmyshow.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Shows show);
}
