package com.example.pocketofficepool;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    private ZonedDateTime deletedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ZonedDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(ZonedDateTime  deletedAt) {
        this.deletedAt = deletedAt;
    }
}
