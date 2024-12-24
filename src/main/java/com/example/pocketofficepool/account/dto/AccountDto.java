package com.example.pocketofficepool.account.dto;

import jakarta.validation.constraints.NotEmpty;

public record AccountDto(
        @NotEmpty(message = "Name is required")
        String name
) {
}
