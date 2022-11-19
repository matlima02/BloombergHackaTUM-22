package src.main.java.com.example.soundx.service;

import src.main.java.com.example.soundx.model.Match;

import java.util.List;

public interface MatchService {
    public Match saveMatch(Match match);
    public List<Match> getAllMatches();
}
