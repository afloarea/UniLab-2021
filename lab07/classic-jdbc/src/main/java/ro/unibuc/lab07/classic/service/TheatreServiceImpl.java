package ro.unibuc.lab07.classic.service;

import org.springframework.stereotype.Service;
import ro.unibuc.lab07.classic.dto.play.AddPlayRequest;
import ro.unibuc.lab07.classic.dto.play.AddPlayResponse;
import ro.unibuc.lab07.classic.dto.play.PlayEntry;
import ro.unibuc.lab07.classic.dto.theatre.CreateTheatreRequest;
import ro.unibuc.lab07.classic.dto.theatre.CreateTheatreResponse;
import ro.unibuc.lab07.classic.dto.theatre.ReadTheatreResponse;
import ro.unibuc.lab07.classic.model.Play;
import ro.unibuc.lab07.classic.model.Theatre;
import ro.unibuc.lab07.classic.repository.PlaysRepository;
import ro.unibuc.lab07.classic.repository.TheatreRepository;

import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final PlaysRepository playsRepo;
    private final TheatreRepository theatreRepo;

    public TheatreServiceImpl(PlaysRepository playsRepo, TheatreRepository theatreRepo) {
        this.playsRepo = playsRepo;
        this.theatreRepo = theatreRepo;
    }

    @Override
    public CreateTheatreResponse addTheatre(CreateTheatreRequest request) {
        final var theatre = new Theatre();
        theatre.setName(request.name());
        theatre.setCity(request.city());

        final var inserted = theatreRepo.insert(theatre);
        return new CreateTheatreResponse(inserted.getId());
    }

    @Override
    public Optional<ReadTheatreResponse> getTheatreById(String theatreId) {
        return theatreRepo.findById(theatreId)
                .map(theatre -> {
                    final var plays = playsRepo.findAllForTheatreId(theatreId).stream()
                            .map(play -> new PlayEntry(play.getTitle(), play.getGenre(), play.getDuration()))
                            .toList();
                    return new ReadTheatreResponse(theatre.getName(), theatre.getCity(), plays);
                });
    }

    @Override
    public Optional<AddPlayResponse> addPlay(String theatreId, AddPlayRequest request) {
        if (!theatreRepo.exists(theatreId)) {
            return Optional.empty();
        }
        final var play = new Play();
        play.setTheatreId(theatreId);
        play.setGenre(request.genre());
        play.setDuration(request.duration());
        play.setTitle(request.title());
        final var inserted = playsRepo.insert(play);

        return Optional.of(new AddPlayResponse(inserted.getId()));
    }

    @Override
    public boolean removePlay(String theatreId, String playId) {
        if (!theatreRepo.exists(theatreId)) {
            return false;
        }
        return playsRepo.delete(playId);
    }
}
