package com.example.soundx.service;


import com.example.soundx.model.Artist;

import java.util.List;

public interface ArtistService {
    public Artist saveArtist(Artist artist);
    public List<Artist> getAllArtists();
}
