package com.example.pocketofficepool.gamegroup;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.game.Game;
import com.example.pocketofficepool.pool.Pool;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
public class GameGroup extends BaseEntity {
    private String name;

    @ManyToOne
    private Pool pool;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "gameGroup")
    private List<Game> games;

    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }
}
