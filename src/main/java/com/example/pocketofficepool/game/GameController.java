package com.example.pocketofficepool.game;

import com.example.pocketofficepool.game.converter.GameDtoToGameConverter;
import com.example.pocketofficepool.game.converter.GameToGameDtoConverter;
import com.example.pocketofficepool.game.dto.GameDto;
import com.example.pocketofficepool.system.Result;
import com.example.pocketofficepool.system.StatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${api.endpoint.base-url}/games")
public class GameController {

    private final GameService gameService;

    private final GameDtoToGameConverter gameDtoToGameConverter;

    private final GameToGameDtoConverter gameToGameDtoConverter;

    public GameController(GameService gameService, GameDtoToGameConverter gameDtoToGameConverter, GameToGameDtoConverter gameToGameDtoConverter) {
        this.gameService = gameService;
        this.gameDtoToGameConverter = gameDtoToGameConverter;
        this.gameToGameDtoConverter = gameToGameDtoConverter;
    }

    @PostMapping()
    public Result createGame(@RequestBody GameDto gameDto) {
        Game game = gameDtoToGameConverter.convert(gameDto);
        Game savedGame = this.gameService.save(game);
        GameDto savedGameDto = gameToGameDtoConverter.convert(savedGame);
        return new Result(true, StatusCode.SUCCESS, "Successfully created game", savedGameDto);
    }

    @GetMapping("/{gameId}")
    public Result getGame(@PathVariable UUID gameId) {
        Game returnedGame = this.gameService.findById(gameId);
        GameDto gameDto = gameToGameDtoConverter.convert(returnedGame);
        return new Result(true, StatusCode.SUCCESS, "Successfully retrieved game", gameDto);
    }

    @PutMapping("/{gameId}")
    public Result updateGame(@PathVariable UUID gameId, @RequestBody GameDto update) {
        Game game = gameDtoToGameConverter.convert(update);
        assert game != null;
        Game updatedGame =  this.gameService.update(gameId, game);
        GameDto updatedGameDto = gameToGameDtoConverter.convert(updatedGame);
        return new Result(true, StatusCode.SUCCESS, "Successfully updated game", updatedGameDto);
    }

    @DeleteMapping("/{gameId}")
    public Result deleteGame(@PathVariable UUID gameId) {
        this.gameService.delete(gameId);
        return new Result(true, StatusCode.SUCCESS, "Successfully deleted game");
    }

}
