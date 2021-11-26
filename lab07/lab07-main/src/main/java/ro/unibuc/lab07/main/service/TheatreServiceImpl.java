package ro.unibuc.lab07.main.service;

import org.springframework.stereotype.Service;
import ro.unibuc.lab07.main.dto.plays.AddPlayRequest;
import ro.unibuc.lab07.main.dto.plays.AddPlayResponse;
import ro.unibuc.lab07.main.dto.plays.PlayEntry;
import ro.unibuc.lab07.main.dto.theatres.CreateTheatreRequest;
import ro.unibuc.lab07.main.dto.theatres.CreateTheatreResponse;
import ro.unibuc.lab07.main.dto.theatres.ReadTheatreResponse;
import ro.unibuc.lab07.main.model.Play;
import ro.unibuc.lab07.main.model.Theatre;
import ro.unibuc.lab07.main.repository.PlayRepository;
import ro.unibuc.lab07.main.repository.TheatreRepository;

import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepo;
    private final PlayRepository playRepo;

    public TheatreServiceImpl(TheatreRepository theatreRepo, PlayRepository playRepo) {
        this.theatreRepo = theatreRepo;
        this.playRepo = playRepo;
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
    public Optional<ReadTheatreResponse> readTheatre(String id) {
        return theatreRepo.read(id)
                .map(theatre -> {
                    final var plays = playRepo.findByTheatreId(theatre.getId()).stream()
                            .map(play -> new PlayEntry(play.getTitle(), play.getGenre(), play.getDuration()))
                            .toList();
                    return new ReadTheatreResponse(theatre.getName(), theatre.getCity(), plays);
                });
    }

    @Override
    public AddPlayResponse addPlay(String theatreId, AddPlayRequest request) {
        if (!theatreRepo.exists(theatreId)) {
            throw new IllegalArgumentException("No theatre for id " + theatreId);
        }
        final var play = new Play();
        play.setTitle(request.title());
        play.setGenre(request.genre());
        play.setDuration(request.duration());
        play.setTheatreId(theatreId);

        final var inserted = playRepo.insert(play);
        return new AddPlayResponse(inserted.getId());
    }

    @Override
    public void removePlay(String theatreId, String playId) {
        if (!theatreRepo.exists(theatreId)) {
            throw new IllegalArgumentException("No theatre for id " + theatreId);
        }

        playRepo.delete(playId);
    }
}
