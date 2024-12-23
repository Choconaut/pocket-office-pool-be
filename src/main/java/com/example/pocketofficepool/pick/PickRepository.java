package com.example.pocketofficepool.pick;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PickRepository extends JpaRepository<Pick, UUID> {

}
