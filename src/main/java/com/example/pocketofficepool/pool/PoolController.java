package com.example.pocketofficepool.pool;

import com.example.pocketofficepool.pool.converter.PoolDtoToPoolConverter;
import com.example.pocketofficepool.pool.converter.PoolToPoolDtoConverter;
import com.example.pocketofficepool.pool.dto.PoolDto;
import com.example.pocketofficepool.system.Result;
import com.example.pocketofficepool.system.StatusCode;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("${api.endpoint.base-url}/pools")
public class PoolController {

    private final PoolService poolService;

    private final PoolDtoToPoolConverter poolDtoToPoolConverter;

    private final PoolToPoolDtoConverter poolToPoolDtoConverter;

    public PoolController(PoolService poolService, PoolDtoToPoolConverter poolDtoToPoolConverter, PoolToPoolDtoConverter poolToPoolDtoConverter) {
        this.poolService = poolService;
        this.poolDtoToPoolConverter = poolDtoToPoolConverter;
        this.poolToPoolDtoConverter = poolToPoolDtoConverter;
    }

    @PostMapping()
    public Result createPool(@RequestBody @Valid PoolDto poolDto) {
        Pool pool = this.poolDtoToPoolConverter.convert(poolDto);
        Pool savedPool = this.poolService.createPool(pool);
        PoolDto savedPoolDto = this.poolToPoolDtoConverter.convert(savedPool);
        return new Result(true, StatusCode.SUCCESS,"Successfully created pool", savedPoolDto);
    }

    @PutMapping("/{poolId}")
    public Pool updatePool(UUID poolId, Pool update) {
        return this.poolService.update(poolId, update);
    }

    @PutMapping("/{poolId}/delete")
    public Pool deletePool(UUID poolId) {
        return this.poolService.delete(poolId);
    }


}
