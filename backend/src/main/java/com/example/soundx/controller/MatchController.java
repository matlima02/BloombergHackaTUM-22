package com.example.soundx.controller;


import com.example.soundx.model.Match;
import com.example.soundx.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
