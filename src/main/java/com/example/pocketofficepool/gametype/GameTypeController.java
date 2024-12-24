package com.example.pocketofficepool.gametype;

import com.example.pocketofficepool.gametype.converter.GameTypeDtoToGameTypeConverter;
import com.example.pocketofficepool.gametype.converter.GameTypeToGameTypeDtoConverter;
import com.example.pocketofficepool.gametype.dto.GameTypeDto;
import com.example.pocketofficepool.system.Result;
import com.example.pocketofficepool.system.StatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${api.endpoint.base-url}/gameTypes")
public class GameTypeController {
    private final GameTypeService gameTypeService;

    private final GameTypeToGameTypeDtoConverter gameTypeToGameTypeDtoConverter;

    private final GameTypeDtoToGameTypeConverter gameTypeDtoToGameTypeConverter;

    public GameTypeController(GameTypeService poolTypeService, GameTypeToGameTypeDtoConverter gameTypeToGameTypeDtoConverter, GameTypeDtoToGameTypeConverter gameTypeDtoToGameTypeConverter) {
        this.gameTypeService = poolTypeService;
        this.gameTypeToGameTypeDtoConverter = gameTypeToGameTypeDtoConverter;
        this.gameTypeDtoToGameTypeConverter = gameTypeDtoToGameTypeConverter;
    }

    @PostMapping()
    public Result createGameType(@RequestBody GameTypeDto gameTypeDto) {
        GameType gameType = this.gameTypeDtoToGameTypeConverter.convert(gameTypeDto);
        GameType savedGameType = this.gameTypeService.save(gameType);
        GameTypeDto savedGameTypeDto = this.gameTypeToGameTypeDtoConverter.convert(savedGameType);
        return new Result(true, StatusCode.SUCCESS, "Successfully created pool type", savedGameTypeDto);
    }

    @GetMapping("/{gameTypeId}")
    public Result getGameType(@PathVariable UUID gameTypeId) {
        GameType foundGameType = this.gameTypeService.findById(gameTypeId);
        GameTypeDto foundGameTypeDto = this.gameTypeToGameTypeDtoConverter.convert(foundGameType);
        return new Result(true, StatusCode.SUCCESS, "Successfully retrieved pool type", foundGameTypeDto);
    }

    @PostMapping("/{gameTypeId}")
    public Result updateGameType(@PathVariable UUID gameTypeId, @RequestBody GameTypeDto update) {
        GameType updatedGameType = this.gameTypeDtoToGameTypeConverter.convert(update);
        assert updatedGameType != null;
        GameType gameType = this.gameTypeService.update(gameTypeId, updatedGameType);
        GameTypeDto updatedGameTypeDto = this.gameTypeToGameTypeDtoConverter.convert(gameType);
        return new Result(true, StatusCode.SUCCESS, "Successfully updated pool type", updatedGameTypeDto);
    }

    @DeleteMapping("/{gameTypeId}")
    public Result deleteGameType(@PathVariable UUID gameTypeId) {
        this.gameTypeService.delete(gameTypeId);
        return new Result(true, StatusCode.SUCCESS, "Successfully deleted pool type");
    }
}
