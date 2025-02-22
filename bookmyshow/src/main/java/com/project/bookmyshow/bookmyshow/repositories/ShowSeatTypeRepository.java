package com.project.bookmyshow.bookmyshow.repositories;

import com.project.bookmyshow.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
}
