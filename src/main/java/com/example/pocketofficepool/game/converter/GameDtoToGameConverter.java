package com.example.pocketofficepool.game.converter;

import com.example.pocketofficepool.game.Game;
import com.example.pocketofficepool.game.dto.GameDto;
import com.example.pocketofficepool.gamegroup.GameGroup;
import com.example.pocketofficepool.gamegroup.GameGroupService;
import com.example.pocketofficepool.gametype.GameType;
import com.example.pocketofficepool.gametype.GameTypeService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameDtoToGameConverter implements Converter<GameDto, Game> {

    private final GameTypeService gameTypeService;

    private final GameGroupService gameGroupService;

    public GameDtoToGameConverter(GameTypeService gameTypeService, GameGroupService gameGroupService) {
        this.gameTypeService = gameTypeService;
        this.gameGroupService = gameGroupService;
    }

    // Returning the gamegroup/gametype might be exposing too much information
    @Override
    public Game convert(GameDto source) {
        Game game = new Game();
        game.setTeam1(source.team1());
        game.setTeam2(source.team2());
        game.setStartTime(source.startTime());
        game.setTeam1Score(source.team1Score());
        game.setTeam2Score(source.team2Score());
        GameGroup gameGroup = gameGroupService.findById(source.gameGroup());
        game.setGameGroup(gameGroup);
        GameType gameType = gameTypeService.findById(source.gameType());
        game.setGameType(gameType);
        return game;
    }
}
