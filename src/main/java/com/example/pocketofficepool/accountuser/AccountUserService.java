package com.example.pocketofficepool.accountuser;

import com.example.pocketofficepool.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class AccountUserService {
    private final AccountUserRepository userRepository;

    public AccountUserService(AccountUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AccountUser findUserById(UUID userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException("user", userId));
    }

    public AccountUser save(AccountUser accountUser) {
        return this.userRepository.save(accountUser);
    }

    public AccountUser update(UUID userId, AccountUser update) {
        AccountUser existingAccountUser = this.findUserById(userId);

        existingAccountUser.setUsername(update.getUsername());
        existingAccountUser.setEmail(update.getEmail());
        existingAccountUser.setRole(update.getRole());

        return this.userRepository.save(existingAccountUser);
    }

    public void delete(UUID userId) {
        AccountUser accountUser = this.findUserById(userId);
        this.userRepository.delete(accountUser);
    }

    public void changePassword(UUID userId, String newPassword) {
        AccountUser accountUser = this.findUserById(userId);
        accountUser.setPassword(newPassword);
        this.userRepository.save(accountUser);
    }
}
