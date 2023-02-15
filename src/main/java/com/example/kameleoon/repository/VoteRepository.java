package com.example.kameleoon.repository;

import com.example.kameleoon.model.Quote;
import com.example.kameleoon.model.User;
import com.example.kameleoon.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findAllByQuote(Quote quote);
    Optional<Vote> findAllByUser(User user);
}
