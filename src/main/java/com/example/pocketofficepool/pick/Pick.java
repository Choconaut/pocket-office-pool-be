package com.example.pocketofficepool.pick;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.accountuser.AccountUser;
import com.example.pocketofficepool.pool.Pool;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Pick extends BaseEntity {

    @ManyToOne
    private AccountUser participant;

    @ManyToOne
    private Pool pool;

    private String pickedTeam;

    public AccountUser getParticipant() {
        return participant;
    }

    public void setParticipant(AccountUser participant) {
        this.participant = participant;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public String getPickedTeam() {
        return pickedTeam;
    }

    public void setPickedTeam(String pickedTeam) {
        this.pickedTeam = pickedTeam;
    }
}
