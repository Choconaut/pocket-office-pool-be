package com.example.pocketofficepool.accountuser.dto;

import com.example.pocketofficepool.Role;
import jakarta.validation.constraints.NotEmpty;

public record UserDto(
        @NotEmpty(message = "Username is required")
        String username,

        @NotEmpty(message = "Email is required")
        String email,

        @NotEmpty(message = "Role is required")
        Role role
) {
}
