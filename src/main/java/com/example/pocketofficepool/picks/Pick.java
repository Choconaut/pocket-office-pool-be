package com.example.pocketofficepool.picks;

import com.example.pocketofficepool.BaseEntity;

import java.util.UUID;

public class Pick extends BaseEntity {
    private UUID userId;
    private UUID poolId;
    private String pickedTeam;
}
