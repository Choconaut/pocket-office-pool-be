package com.example.pocketofficepool.game;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.gamegroup.GameGroup;
import com.example.pocketofficepool.gametype.GameType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.ZonedDateTime;

@Entity
public class Game extends BaseEntity {

    private String team1;

    private String team2;

// Used for spread betting
//    private float spread;

    private ZonedDateTime startTime;

    private Integer team1Score;

    private Integer team2Score;

    @ManyToOne
    private GameGroup gameGroup;

    @ManyToOne
    private GameType gameType;

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public Integer getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(Integer team1Score) {
        this.team1Score = team1Score;
    }

    public Integer getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(Integer team2Score) {
        this.team2Score = team2Score;
    }

    public GameType getPoolType() {
        return gameType;
    }

    public void setPoolType(GameType gameType) {
        this.gameType = gameType;
    }

    public GameGroup getGameGroup() {
        return gameGroup;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public void setGameGroup(GameGroup gameGroup) {
        this.gameGroup = gameGroup;
    }
}
