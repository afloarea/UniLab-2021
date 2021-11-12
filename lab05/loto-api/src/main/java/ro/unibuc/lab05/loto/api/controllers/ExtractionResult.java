package ro.unibuc.lab05.loto.api.controllers;

import java.util.List;

public record ExtractionResult(int[] winningCombination, List<String> winners) {
}
