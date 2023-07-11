package com.cardKeeper.cardKeeperAPI.Domain.cards;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cards")
@Entity(name = "Cards")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "CardID")
@Getter
public class Cards {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CardID;
    private String CardName;
    private String CardCode;
    private String CardQuality;
    private String CardsAmount;
    private String CardSleeve;
    private String CardImage;

    public Cards(CardsPostDTO objCardsDTO) {
        this.CardName = objCardsDTO.CardName();
        this.CardCode = objCardsDTO.CardCode();
        this.CardQuality = objCardsDTO.CardQuality();
        this.CardsAmount = objCardsDTO.CardsAmount();
        this.CardSleeve = objCardsDTO.CardSleeve();
        this.CardImage = objCardsDTO.CardImage();
    }

    public void Update(CardsPutDTO cardsPUT){
        if(cardsPUT.CardName() != null){
            this.CardName = cardsPUT.CardName();
        }
        if(cardsPUT.CardCode() != null){
            this.CardCode = cardsPUT.CardCode();
        }
        if(cardsPUT.CardQuality() != null){
            this.CardQuality = cardsPUT.CardQuality();
        }
        if(cardsPUT.CardsAmount() != null){
            this.CardsAmount = cardsPUT.CardsAmount();
        }

    }
}
