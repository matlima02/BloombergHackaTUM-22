package src.main.java.com.example.soundx.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.example.soundx.model.Match;
import src.main.java.com.example.soundx.service.MatchService;

import java.util.List;

@RestController
@RequestMapping("/match")
@CrossOrigin
public class MatchController {
    @Autowired
    private MatchService matchService;

    @PostMapping("/add")
    public String add(@RequestBody Match match){
        matchService.saveMatch(match);
        return "New match is added!";
    }

    @GetMapping("/getAll")
    public List<Match> getAllMatchs() {
        return matchService.getAllMatches();
    }
}
