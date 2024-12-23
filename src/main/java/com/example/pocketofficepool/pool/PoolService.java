package com.example.pocketofficepool.pool;

import com.example.pocketofficepool.pooltype.PoolType;
import com.example.pocketofficepool.pooltype.PoolTypeRepository;
import com.example.pocketofficepool.system.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class PoolService {

    private final PoolRepository poolRepository;
    private final PoolTypeRepository poolTypeRepository;

    public PoolService(PoolRepository poolRepository, PoolTypeRepository poolTypeRepository) {
        this.poolRepository = poolRepository;
        this.poolTypeRepository = poolTypeRepository;
    }

    public Pool save(Pool pool) {
        PoolType poolType = this.poolTypeRepository.findById(pool.getPoolType().getId())
                .orElseThrow(() -> new ObjectNotFoundException("pool type", pool.getPoolType().getId()));
        pool.setPoolType(poolType);
        return this.poolRepository.save(pool);
    }

    public Pool findById(UUID poolId) {
        return this.poolRepository.findById(poolId)
                .orElseThrow(() -> new ObjectNotFoundException("pool", poolId));
    }

    public Pool update(UUID poolId, Pool update) {
        Pool pool = this.findById(poolId);

        pool.setBettingType(update.getBettingType());
        pool.setCloseTime(update.getCloseTime());
        pool.setOpenTime(update.getOpenTime());
        pool.setName(update.getName());
        pool.setStatus(update.getStatus());

        return this.save(pool);
    }

    public Pool delete(UUID poolId) {
        Pool pool = this.findById(poolId);

        pool.setDeletedAt(ZonedDateTime.now());
        return this.poolRepository.save(pool);
    }

    public Pool createPool(Pool pool) {
        // TODO: Get authenticated user and set owner to authenticated user if
        // authenticated user is an admin/owner

        return this.save(pool);
    }
}
