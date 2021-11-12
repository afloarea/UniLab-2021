package ro.unibuc.lab05.loto.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.lab05.loto.api.dto.LotoRegistration;
import ro.unibuc.lab05.loto.api.services.LotoService;

import java.util.Arrays;
import java.util.Map;

@RestController
public class LotoController {

    private final LotoService lotoService;

    public LotoController(LotoService lotoService) {
        this.lotoService = lotoService;
    }

    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRegistration(@RequestBody LotoRegistration registration) {
        lotoService.registerTicket(registration);
    }

    @GetMapping("/winners")
    public ResponseEntity<Object> runExtraction(@RequestHeader(name = "x-cheat", defaultValue = "0") double cheatChance,
                                        @RequestHeader(value = "x-cheat-values", required = false) int[] cheatValues) {
        if (cheatChance > 0D && cheatValues == null) {
            return ResponseEntity.status(404).body(Map.of("message", "learn to cheat"));
        }
        return ResponseEntity.ok(lotoService.extractWinners(cheatChance, cheatValues));
    }

}
