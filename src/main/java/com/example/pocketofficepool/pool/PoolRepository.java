package com.example.pocketofficepool.pool;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface PoolRepository extends JpaRepository<Pool, UUID> {
}
