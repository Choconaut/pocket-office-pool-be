package com.example.pocketofficepool.game;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.pooltype.PoolType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.ZonedDateTime;

@Entity
class Game extends BaseEntity {
    private String team1;
    private String team2;
    private ZonedDateTime startTime;

    @ManyToOne
    private PoolType poolType;

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

    public PoolType getPoolType() {
        return poolType;
    }

    public void setPoolType(PoolType poolType) {
        this.poolType = poolType;
    }
}
