package com.example.pocketofficepool.pooltype;

import com.example.pocketofficepool.system.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PoolTypeService {
    private final PoolTypeRepository poolTypeRepository;

    public PoolTypeService(PoolTypeRepository poolTypeRepository) {
        this.poolTypeRepository = poolTypeRepository;
    }

    public PoolType findPoolTypeById(UUID poolTypeId) {
        return this.poolTypeRepository.findById(poolTypeId)
                .orElseThrow(() -> new ObjectNotFoundException("pool type", poolTypeId));
    }
}
