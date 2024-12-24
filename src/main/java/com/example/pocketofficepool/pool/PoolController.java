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
        assert pool != null;
        Pool savedPool = this.poolService.save(pool);
        PoolDto savedPoolDto = this.poolToPoolDtoConverter.convert(savedPool);
        return new Result(true, StatusCode.SUCCESS,"Successfully created pool", savedPoolDto);
    }

    // Don't think there's a reason for pools to have unique names so it searches by id
    @PostMapping("/{poolId}")
    public Result getPool(@PathVariable UUID poolId) {
        Pool pool = this.poolService.findById(poolId);
        PoolDto poolDto = this.poolToPoolDtoConverter.convert(pool);
        return new Result(true, StatusCode.SUCCESS, "Successfully retrieved pool", poolDto);
    }

    @PutMapping("/{poolId}")
    public Result updatePool(@PathVariable UUID poolId, @RequestBody PoolDto update) {
        Pool pool = this.poolDtoToPoolConverter.convert(update);
        assert pool != null;
        Pool updatedPool = this.poolService.update(poolId, pool);
        PoolDto updatedPoolDto = this.poolToPoolDtoConverter.convert(updatedPool);
        return new Result(true, StatusCode.SUCCESS, "Successfully updated pool", updatedPoolDto);
    }

    @PutMapping("/{poolId}")
    public Result deletePool(@PathVariable UUID poolId) {
        this.poolService.delete(poolId);
        return new Result(true, StatusCode.SUCCESS, "Successfully deleted pool");
    }
}
