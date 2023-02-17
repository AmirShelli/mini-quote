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
    @Query("SELECT q FROM Quote q WHERE q.user=:user")
    List<Quote> findAllByUser(User user);
    @Query("SELECT q FROM Quote q ORDER BY q.numberOfVotes DESC")
    List<Quote> findTopTenQuotes();
    @Query("SELECT q FROM Quote q ORDER BY q.numberOfVotes ASC")
    List<Quote> findFlopTenQuotes();
}