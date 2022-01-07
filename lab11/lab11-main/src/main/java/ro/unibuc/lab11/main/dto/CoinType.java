package ro.unibuc.lab11.main.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CoinType {
    @JsonProperty("ProofOfWork") PROOF_OF_WORK,
    @JsonProperty("ProofOfStake") PROOF_OF_STAKE
}
