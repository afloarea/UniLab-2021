package ro.unibuc.lab07.main.service;

import ro.unibuc.lab07.main.dto.plays.AddPlayRequest;
import ro.unibuc.lab07.main.dto.plays.AddPlayResponse;
import ro.unibuc.lab07.main.dto.theatres.CreateTheatreRequest;
import ro.unibuc.lab07.main.dto.theatres.CreateTheatreResponse;
import ro.unibuc.lab07.main.dto.theatres.ReadTheatreResponse;

import java.util.Optional;

public interface TheatreService {

    CreateTheatreResponse addTheatre(CreateTheatreRequest request);

    Optional<ReadTheatreResponse> readTheatre(String id);

    AddPlayResponse addPlay(String theatreId, AddPlayRequest request);

    void removePlay(String theatreId, String playId);

}
