package com.example.pocketofficepool.pool.converter;

import com.example.pocketofficepool.pool.Pool;
import com.example.pocketofficepool.pool.dto.PoolDto;
import com.example.pocketofficepool.gametype.GameType;
import com.example.pocketofficepool.gametype.GameTypeService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PoolDtoToPoolConverter implements Converter<PoolDto, Pool> {

    private final GameTypeService gameTypeService;

    public PoolDtoToPoolConverter(GameTypeService gameTypeService) {
        this.gameTypeService = gameTypeService;
    }

    @Override
    public Pool convert(PoolDto source) {
        Pool pool = new Pool();
        pool.setName(source.name());
        pool.setBettingType(source.bettingType());
        pool.setOpenTime(source.openTime());
        pool.setCloseTime(source.closeTime());
        GameType gameType = gameTypeService.findById(source.gameType());
        pool.setGameType(gameType);
        return pool;
    }
}
