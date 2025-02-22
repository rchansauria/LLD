package com.project.bookmyshow.bookmyshow.repositories;

import com.project.bookmyshow.bookmyshow.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long> {
}
