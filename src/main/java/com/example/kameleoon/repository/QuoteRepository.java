package com.example.kameleoon.repository;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Optional<Quote> findAllByUser(User user);
    @Query("SELECT q, count(v.value) as voteCount FROM Quote q LEFT JOIN q.votes v GROUP BY q ORDER BY voteCount DESC")
    List<Quote> findTopTenQuotes();
    @Query("SELECT q, count(v.value) as voteCount FROM Quote q LEFT JOIN q.votes v GROUP BY q ORDER BY voteCount ASC")
    List<Quote> findFlopTenQuotes();
}