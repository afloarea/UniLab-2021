package ro.unibuc.lab07.classic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.lab07.classic.dto.play.AddPlayRequest;
import ro.unibuc.lab07.classic.dto.play.AddPlayResponse;
import ro.unibuc.lab07.classic.dto.theatre.CreateTheatreRequest;
import ro.unibuc.lab07.classic.dto.theatre.CreateTheatreResponse;
import ro.unibuc.lab07.classic.dto.theatre.ReadTheatreResponse;
import ro.unibuc.lab07.classic.service.TheatreService;

@RequestMapping("/theatres")
@RestController
public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<ReadTheatreResponse> getTheatre(@PathVariable String theatreId) {
        return ResponseEntity.of(theatreService.getTheatreById(theatreId));
    }

    @PostMapping
    public CreateTheatreResponse createTheatre(@RequestBody CreateTheatreRequest request) {
        return theatreService.addTheatre(request);
    }

    @PostMapping("/{theatreId}/plays")
    public ResponseEntity<AddPlayResponse> addPlay(@PathVariable("theatreId") String theatreId, @RequestBody AddPlayRequest request) {
        return ResponseEntity.of(theatreService.addPlay(theatreId, request));
    }

    @DeleteMapping("/{theatreId}/plays/{playId}")
    public ResponseEntity<Void> deletePlay(@PathVariable("theatreId") String theatreId,
                                           @PathVariable("playId") String playId) {
        return theatreService.removePlay(theatreId, playId)
                ? ResponseEntity.ok(null)
                : ResponseEntity.status(404).body(null);
    }
}
