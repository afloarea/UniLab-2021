package ro.unibuc.lab05.loto.api.services;

import ro.unibuc.lab05.loto.api.controllers.ExtractionResult;
import ro.unibuc.lab05.loto.api.dto.LotoRegistration;

public interface LotoService {

    void registerTicket(LotoRegistration ticket);

    ExtractionResult extractWinners(double cheatChance, int[] cheatValues);

}
