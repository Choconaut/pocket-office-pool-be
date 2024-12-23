package com.example.pocketofficepool.user;

import com.example.pocketofficepool.system.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(UUID userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException("user", userId));
    }
}
