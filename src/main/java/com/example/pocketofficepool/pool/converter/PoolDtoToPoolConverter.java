package com.example.pocketofficepool.pool.converter;

import com.example.pocketofficepool.pool.Pool;
import com.example.pocketofficepool.pool.dto.PoolDto;
import com.example.pocketofficepool.pooltype.PoolType;
import com.example.pocketofficepool.pooltype.PoolTypeService;
import com.example.pocketofficepool.user.User;
import com.example.pocketofficepool.user.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PoolDtoToPoolConverter implements Converter<PoolDto, Pool> {

    private final PoolTypeService poolTypeService;

    public PoolDtoToPoolConverter(PoolTypeService poolTypeService) {
        this.poolTypeService = poolTypeService;
    }

    @Override
    public Pool convert(PoolDto source) {
        Pool pool = new Pool();
        pool.setName(source.name());
        pool.setBettingType(source.bettingType());
        pool.setOpenTime(source.openTime());
        pool.setCloseTime(source.closeTime());
        PoolType poolType = poolTypeService.findPoolTypeById(source.poolType());
        pool.setPoolType(poolType);
        return pool;
    }
}
