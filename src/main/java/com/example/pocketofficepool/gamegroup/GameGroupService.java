package com.example.pocketofficepool.gamegroup;

import com.example.pocketofficepool.game.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameGroupService {

    private final GameGroupRepository gameGroupRepository;

    private final GameRepository gameRepository;

    public GameGroupService(GameGroupRepository gameGroupRepository, GameRepository gameRepository) {
        this.gameGroupRepository = gameGroupRepository;
        this.gameRepository = gameRepository;
    }

    public GameGroup save(GameGroup gameGroup) {
        return gameGroupRepository.save(gameGroup);
    }

}
