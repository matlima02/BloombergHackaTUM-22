package com.example.soundx.model;
import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int matchCustomerId;
    private int matchArtistId;
    private int matchedAmount;
    private double matchedPrice;

    public Match() {
    }

    public int getMatchCustomerId() {
        return matchCustomerId;
    }

    public void setMatchCustomerId(int matchCustomerId) {
        this.matchCustomerId = matchCustomerId;
    }

    public int getMatchArtistId() {
        return matchArtistId;
    }

    public void setMatchArtistId(int matchArtistId) {
        this.matchArtistId = matchArtistId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getMatchedAmount() {
        return matchedAmount;
    }

    public void setMatchedAmount(int matchedAmount) {
        this.matchedAmount = matchedAmount;
    }

    public double getMatchedPrice() {
        return matchedPrice;
    }

    public void setMatchedPrice(double matchedPrice) {
        this.matchedPrice = matchedPrice;
    }
}
