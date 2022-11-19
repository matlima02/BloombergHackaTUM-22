package src.main.java.com.example.soundx.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.example.soundx.model.Artist;
import src.main.java.com.example.soundx.service.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/artist")
@CrossOrigin
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @PostMapping("/add")
    public String add(@RequestBody Artist artist){
        artistService.saveArtist(artist);
        return "New custoer is added!";
    }

    @GetMapping("/getAll")
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }
}
