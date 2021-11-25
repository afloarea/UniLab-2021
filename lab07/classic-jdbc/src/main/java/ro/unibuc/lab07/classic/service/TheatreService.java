package ro.unibuc.lab07.classic.service;

import ro.unibuc.lab07.classic.dto.play.AddPlayRequest;
import ro.unibuc.lab07.classic.dto.play.AddPlayResponse;
import ro.unibuc.lab07.classic.dto.theatre.CreateTheatreResponse;
import ro.unibuc.lab07.classic.dto.theatre.CreateTheatreRequest;
import ro.unibuc.lab07.classic.dto.theatre.ReadTheatreResponse;

import java.util.Optional;

public interface TheatreService {

    CreateTheatreResponse addTheatre(CreateTheatreRequest request);

    Optional<ReadTheatreResponse> getTheatreById(String theatreId);

    Optional<AddPlayResponse> addPlay(String theatreId, AddPlayRequest request);

    boolean removePlay(String theatreId, String playId);

}
