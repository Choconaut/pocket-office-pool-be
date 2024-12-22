package com.example.pocketofficepool.pool;

import com.example.pocketofficepool.BaseEntity;
import com.example.pocketofficepool.Status;
import com.example.pocketofficepool.pooltype.PoolType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.ZonedDateTime;

@Entity
class Pool extends BaseEntity {
    private ZonedDateTime openTime;
    private ZonedDateTime closeTime;
    private Status status;

    @ManyToOne
    private PoolType poolType;

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

    public PoolType getPoolType() {
        return poolType;
    }

    public void setPoolType(PoolType poolType) {
        this.poolType = poolType;
    }
}
