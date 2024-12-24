package com.example.pocketofficepool.game.dto;

import jakarta.validation.constraints.NotEmpty;

import java.time.ZonedDateTime;
import java.util.UUID;

public record GameDto(
        @NotEmpty(message = "Team 1 is required")
        String team1,

        @NotEmpty(message = "Team 2 is required")
        String team2,

        @NotEmpty(message = "Start time is required")
        ZonedDateTime startTime,

        @NotEmpty(message = "Team 1 score is required")
        Integer team1Score,

        @NotEmpty(message = "Team 2 score is required")
        Integer team2Score,

        @NotEmpty(message = "Game group is required")
        UUID gameGroup,

        @NotEmpty(message = "Pool type is required")
        UUID gameType
) {
}
