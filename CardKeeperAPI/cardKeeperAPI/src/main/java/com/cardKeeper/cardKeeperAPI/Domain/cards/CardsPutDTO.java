package com.cardKeeper.cardKeeperAPI.Domain.cards;

import jakarta.validation.constraints.NotNull;

public record CardsPutDTO(
        @NotNull
        Long id,
        String CardName,
        String CardCode,
        String CardQuality,
        String CardsAmount,
        String CardSleeve,
        String CardImage) {

}
