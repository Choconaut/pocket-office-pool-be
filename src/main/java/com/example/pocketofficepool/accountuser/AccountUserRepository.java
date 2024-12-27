package com.example.pocketofficepool.accountuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountUserRepository extends JpaRepository<AccountUser, UUID> {

}
