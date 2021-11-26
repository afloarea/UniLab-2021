package ro.unibuc.lab07.main.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.lab07.main.dto.plays.AddPlayRequest;
import ro.unibuc.lab07.main.dto.plays.AddPlayResponse;
import ro.unibuc.lab07.main.dto.theatres.CreateTheatreRequest;
import ro.unibuc.lab07.main.dto.theatres.CreateTheatreResponse;
import ro.unibuc.lab07.main.dto.theatres.ReadTheatreResponse;
import ro.unibuc.lab07.main.service.TheatreService;

@RequestMapping("/theatres")
@RestController
public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping
    public CreateTheatreResponse createTheatre(@RequestBody CreateTheatreRequest request) {
        return theatreService.addTheatre(request);
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<ReadTheatreResponse> readTheatre(@PathVariable("theatreId") String theatreId) {
        return ResponseEntity.of(theatreService.readTheatre(theatreId));
    }

    @PostMapping("/{theatreId}/plays")
    public AddPlayResponse addPlay(@PathVariable("theatreId") String theatreId, @RequestBody AddPlayRequest request) {
        return theatreService.addPlay(theatreId, request);
    }

    @DeleteMapping("/{theatreId}/plays/{playId}")
    public void removePlay(@PathVariable("theatreId") String theatreId, @PathVariable("playId") String playId) {
        theatreService.removePlay(theatreId, playId);
    }
}
