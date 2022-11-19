package com.example.soundx.service;

import com.example.soundx.model.Match;

import java.util.List;

public interface MatchService {
    public Match saveMatch(Match match);
    public List<Match> getAllMatches();
}
