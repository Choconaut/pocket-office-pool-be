package com.example.pocketofficepool.game;

import com.example.pocketofficepool.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
@Transactional
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public Game findById(UUID id) {
        return gameRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("game", id));
    }

    public Game update(UUID id, Game update) {
        Game game = findById(id);

        game.setTeam1(update.getTeam1());
        game.setTeam2(update.getTeam2());
        game.setSpread(update.getSpread());
        game.setStartTime(update.getStartTime());
        game.setTeam1Score(update.getTeam1Score());
        game.setTeam2Score(update.getTeam2Score());

        return save(game);
    }

    public Game delete(UUID id) {
        Game game = findById(id);
        game.setDeletedAt(ZonedDateTime.now());
        return gameRepository.save(game);
    }
}
