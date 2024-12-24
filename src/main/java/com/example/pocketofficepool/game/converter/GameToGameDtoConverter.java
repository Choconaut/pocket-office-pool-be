package com.example.pocketofficepool.game.converter;

import com.example.pocketofficepool.game.Game;
import com.example.pocketofficepool.game.dto.GameDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameToGameDtoConverter implements Converter<Game, GameDto> {
    @Override
    public GameDto convert(Game source) {
        return new GameDto(
                source.getTeam1(),
                source.getTeam2(),
                source.getStartTime(),
                source.getTeam1Score(),
                source.getTeam2Score(),
                source.getGameGroup().getId(),
                source.getGameType().getId()
        );
    }
}
