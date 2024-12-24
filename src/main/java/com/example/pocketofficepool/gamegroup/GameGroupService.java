package com.example.pocketofficepool.gamegroup;

import com.example.pocketofficepool.game.GameRepository;
import com.example.pocketofficepool.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@Transactional
public class GameGroupService {

    private final GameGroupRepository gameGroupRepository;

    public GameGroupService(GameGroupRepository gameGroupRepository) {
        this.gameGroupRepository = gameGroupRepository;
    }

    public GameGroup save(GameGroup gameGroup) {
        return gameGroupRepository.save(gameGroup);
    }

    public GameGroup findById(UUID GameGroupId) {
        return gameGroupRepository.findById(GameGroupId)
                .orElseThrow(() -> new ObjectNotFoundException("game group", GameGroupId));
    }

    public GameGroup update(UUID GameGroupId, GameGroup update) {
        GameGroup gameGroup = this.findById(GameGroupId);

        gameGroup.setName(update.getName());
        gameGroup.setGames(update.getGames());

        return this.save(gameGroup);
    }

    public void delete(UUID GameGroupId) {
        GameGroup gameGroup = this.findById(GameGroupId);

        gameGroup.setDeletedAt(ZonedDateTime.now());
        this.gameGroupRepository.save(gameGroup);
    }
}
