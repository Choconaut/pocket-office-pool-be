package com.example.pocketofficepool.pooltype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PoolTypeRepository extends JpaRepository<PoolType, UUID> {
}
