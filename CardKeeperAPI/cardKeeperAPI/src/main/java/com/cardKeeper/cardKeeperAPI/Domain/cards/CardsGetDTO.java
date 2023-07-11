package com.cardKeeper.cardKeeperAPI.Domain.cards;

public record CardsGetDTO(Long id, String CardName, String CardCode, String CardQuality, String CardsAmount, String CardSleeve, String CardImage) {

    public CardsGetDTO(Cards cards){
        this(cards.getCardID(), cards.getCardName(), cards.getCardCode(), cards.getCardQuality(), cards.getCardsAmount(), cards.getCardSleeve(), cards.getCardImage());
    }

}
