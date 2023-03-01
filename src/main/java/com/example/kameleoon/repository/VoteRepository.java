package com.example.kameleoon.repository;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("SELECT v.value FROM Vote v WHERE v.quote = :quote ORDER BY v.created_At")
    List<Vote> getVotesByQuote(Quote quote);
}
