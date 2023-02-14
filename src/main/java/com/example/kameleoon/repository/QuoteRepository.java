package com.example.kameleoon.repository;
import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Optional<Quote> findAllByUser(User user);

}