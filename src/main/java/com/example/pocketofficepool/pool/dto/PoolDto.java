package com.example.pocketofficepool.pool.dto;

import com.example.pocketofficepool.BettingType;
import com.example.pocketofficepool.Status;

import java.time.ZonedDateTime;
import java.util.UUID;

public record PoolDto(
        String name,

        BettingType bettingType,

        ZonedDateTime openTime,

        ZonedDateTime closeTime,

        UUID poolType
) {
}
