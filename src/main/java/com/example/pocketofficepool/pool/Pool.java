package com.example.pocketofficepool.pool;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.BettingType;
import com.example.pocketofficepool.Status;
import com.example.pocketofficepool.accountuser.AccountUser;
import com.example.pocketofficepool.gamegroup.GameGroup;
import com.example.pocketofficepool.pick.Pick;
import com.example.pocketofficepool.gametype.GameType;
import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
public class Pool extends BaseEntity {

    private String name;

    @ManyToOne
    private AccountUser owner;

    @Enumerated(EnumType.STRING)
    private BettingType bettingType; // Straight up, spread

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "pool")
    private List<Pick> picks;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "pool")
    private List<GameGroup> gameGroups; // Groups of games in this pool

    private ZonedDateTime openTime; // When picks can be made

    private ZonedDateTime closeTime; // When picks can no longer be made

    private Status status;

    @ManyToOne
    private GameType gameType;

    public ZonedDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(ZonedDateTime openTime) {
        this.openTime = openTime;
    }

    public ZonedDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(ZonedDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountUser getOwner() {
        return owner;
    }

    public void setOwner(AccountUser owner) {
        this.owner = owner;
    }

    public BettingType getBettingType() {
        return bettingType;
    }

    public void setBettingType(BettingType bettingType) {
        this.bettingType = bettingType;
    }

    public List<Pick> getPicks() {
        return picks;
    }

    public void setPicks(List<Pick> picks) {
        this.picks = picks;
    }

    public List<GameGroup> getGameGroups() {
        return gameGroups;
    }

    public void setGameGroups(List<GameGroup> gameGroups) {
        this.gameGroups = gameGroups;
    }
}
