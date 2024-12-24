package com.example.pocketofficepool.gametype.converter;

import com.example.pocketofficepool.gametype.GameType;
import com.example.pocketofficepool.gametype.dto.GameTypeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameTypeToGameTypeDtoConverter implements Converter<GameType, GameTypeDto> {
    @Override
    public GameTypeDto convert(GameType source) {
        return new GameTypeDto(
                source.getName()
        );
    }
}
