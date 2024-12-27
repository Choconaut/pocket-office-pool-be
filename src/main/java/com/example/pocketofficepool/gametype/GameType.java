package com.example.pocketofficepool.gametype;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.game.Game;
import com.example.pocketofficepool.pool.Pool;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class GameType extends BaseEntity {

    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "gameType")
    private List<Pool> pools;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "gameType")
    private List<Game> games;

    // For future use to grab data from an API
//    private String apiEndpoint;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pool> getPools() {
        return pools;
    }

    public void setPools(List<Pool> pools) {
        this.pools = pools;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
