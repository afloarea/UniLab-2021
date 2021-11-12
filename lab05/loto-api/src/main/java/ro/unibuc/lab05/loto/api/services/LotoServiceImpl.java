package ro.unibuc.lab05.loto.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ro.unibuc.lab05.loto.api.controllers.ExtractionResult;
import ro.unibuc.lab05.loto.api.dto.LotoRegistration;

import java.util.List;

@Service
public class LotoServiceImpl implements LotoService {

    private final WebClient webClient = WebClient.create();

    private final String extractorUrl;
    private final String registryUrl;

    public LotoServiceImpl(@Value("${url.extractor}") String extractorUrl, @Value("${url.registry}")String registryUrl) {
        this.extractorUrl = extractorUrl;
        this.registryUrl = registryUrl;
    }

    @Override
    public void registerTicket(LotoRegistration ticket) {
        webClient.post().uri(registryUrl + "/registration")
                .bodyValue(ticket)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Override
    public ExtractionResult extractWinners(double cheatChance, int[] cheatValues) {
        final var extractionResult = Double.compare(cheatChance, 0D) == 0
                ? performExtraction() : cheat(cheatChance, cheatValues);

        final var winners = webClient.post().uri(registryUrl + "/query")
                .bodyValue(extractionResult)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {})
                .block();

        return new ExtractionResult(extractionResult, winners);
    }

    private int[] performExtraction() {
        return webClient.get().uri(extractorUrl + "/extraction")
                .retrieve()
                .bodyToMono(int[].class)
                .block();
    }

    private int[] cheat(double cheatChange, int[] cheatValues) {
        if (Math.random() < cheatChange) {
            return cheatValues;
        }
        return performExtraction();
    }
}
