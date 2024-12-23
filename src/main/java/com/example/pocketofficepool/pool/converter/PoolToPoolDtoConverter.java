package com.example.pocketofficepool.pool.converter;

import com.example.pocketofficepool.pool.Pool;
import com.example.pocketofficepool.pool.dto.PoolDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PoolToPoolDtoConverter implements Converter<Pool, PoolDto> {
    @Override
    public PoolDto convert(Pool source) {
        return new PoolDto(
                source.getName(),
                source.getBettingType(),
                source.getOpenTime(),
                source.getCloseTime(),
                source.getPoolType().getId()
        );
    }
}
