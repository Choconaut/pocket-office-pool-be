package com.example.pocketofficepool.gametype.converter;

import com.example.pocketofficepool.gametype.GameType;
import com.example.pocketofficepool.gametype.dto.GameTypeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameTypeDtoToGameTypeConverter implements Converter<GameTypeDto, GameType> {
    @Override
    public GameType convert(GameTypeDto source) {
        GameType gameType = new GameType();
        gameType.setName(source.name());
        return gameType;
    }
}
