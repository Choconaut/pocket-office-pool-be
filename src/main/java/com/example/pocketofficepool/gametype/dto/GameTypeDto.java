package com.example.pocketofficepool.gametype.dto;

import jakarta.validation.constraints.NotEmpty;

public record GameTypeDto(
        @NotEmpty(message = "GameType name is required")
        String name
) {
}
