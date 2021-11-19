package ro.unibuc.lab06.main.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.lab06.main.dto.AddGameResponse;
import ro.unibuc.lab06.main.dto.GameDto;
import ro.unibuc.lab06.main.services.GameService;

import javax.validation.Valid;

@RestController
@RequestMapping("/games")
@Validated
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public AddGameResponse addGame(@Valid @RequestBody GameDto body, @RequestHeader String requestId) {
        return gameService.addGame(body);
    }

    @GetMapping("/{gameId}")
    public GameDto getGame(@PathVariable("gameId") int id) {
        return gameService.getById(id);
    }
}
