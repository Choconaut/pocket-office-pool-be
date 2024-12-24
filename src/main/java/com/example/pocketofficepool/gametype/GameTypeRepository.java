package com.example.pocketofficepool.gametype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameTypeRepository extends JpaRepository<GameType, UUID> {
}
