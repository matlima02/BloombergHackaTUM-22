package com.example.soundx.repository;

import com.example.soundx.model.Customer;
import com.example.soundx.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match,Integer> {

}
