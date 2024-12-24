package com.example.pocketofficepool.pool.dto;

import com.example.pocketofficepool.BettingType;
import jakarta.validation.constraints.NotEmpty;

import java.time.ZonedDateTime;
import java.util.UUID;

public record PoolDto(
        @NotEmpty(message = "Pool name is required")
        String name,

        @NotEmpty(message = "Betting type is required")
        BettingType bettingType,

        @NotEmpty(message = "Open time is required")
        ZonedDateTime openTime,

        @NotEmpty(message = "Close time is required")
        ZonedDateTime closeTime,

        @NotEmpty(message = "Game group is required")
        UUID poolType
) {
}
