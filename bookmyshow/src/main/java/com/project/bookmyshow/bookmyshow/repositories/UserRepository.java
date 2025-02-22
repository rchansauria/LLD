package com.project.bookmyshow.bookmyshow.repositories;

import com.project.bookmyshow.bookmyshow.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Override
    Optional<Users> findById(Long userId);
    Optional<Users> findByEmail(String email);
}
