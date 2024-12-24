package com.example.pocketofficepool.gametype;

import com.example.pocketofficepool.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@Transactional
public class GameTypeService {
    private final GameTypeRepository gameTypeRepository;

    public GameTypeService(GameTypeRepository gameTypeRepository) {
        this.gameTypeRepository = gameTypeRepository;
    }

    public GameType findById(UUID gameTypeId) {
        return this.gameTypeRepository.findById(gameTypeId)
                .orElseThrow(() -> new ObjectNotFoundException("pool type", gameTypeId));
    }

    public GameType save(GameType gameType) {
        return this.gameTypeRepository.save(gameType);
    }

    public GameType update(UUID gameTypeId, GameType update) {
        GameType gameType = this.findById(gameTypeId);

        gameType.setName(update.getName());

        return this.save(gameType);
    }

    public void delete(UUID gameTypeId) {
        GameType gameType = this.findById(gameTypeId);

        gameType.setDeletedAt(ZonedDateTime.now());
        this.gameTypeRepository.save(gameType);
    }
}
