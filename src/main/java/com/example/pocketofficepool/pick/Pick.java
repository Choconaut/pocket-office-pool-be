package com.example.pocketofficepool.pick;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.pool.Pool;
import com.example.pocketofficepool.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Pick extends BaseEntity {

    @ManyToOne
    private User participant;

    @ManyToOne
    private Pool pool;

    private String pickedTeam;

    public User getParticipant() {
        return participant;
    }

    public void setParticipant(User participant) {
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
