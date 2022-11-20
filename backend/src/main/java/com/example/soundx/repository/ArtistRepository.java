package com.example.soundx.repository;


import com.example.soundx.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistRepository extends JpaRepository<Artist,Integer> {

}
