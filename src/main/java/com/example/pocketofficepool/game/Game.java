package com.example.pocketofficepool.game;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.gamegroup.GameGroup;
import com.example.pocketofficepool.pool.Pool;
import com.example.pocketofficepool.pooltype.PoolType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.ZonedDateTime;

@Entity
public class Game extends BaseEntity {

    private String team1;

    private String team2;

    private float spread;

    private ZonedDateTime startTime;

    private Integer team1Score;

    private Integer team2Score;

    @ManyToOne
    private GameGroup gameGroup;

    @ManyToOne
    private PoolType poolType;

    @ManyToOne
    private Pool pool; // Pool this game belongs to

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

    public float getSpread() {
        return spread;
    }

    public void setSpread(float spread) {
        this.spread = spread;
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

    public PoolType getPoolType() {
        return poolType;
    }

    public void setPoolType(PoolType poolType) {
        this.poolType = poolType;
    }
}
