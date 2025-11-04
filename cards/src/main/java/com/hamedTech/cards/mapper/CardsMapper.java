package com.hamedTech.cards.mapper;

import com.hamedTech.cards.dto.CardDto;
import com.hamedTech.cards.entity.Card;

public class CardsMapper {


    public static Card toCard(CardDto cardDto, Card card){


        card.setCardNumber(cardDto.getCardNumber());
        card.setMobileNumber(cardDto.getMobileNumber());
        card.setCardType(cardDto.getCardType());
        card.setTotalLimit(cardDto.getTotalLimit());
        card.setAmountUsed(cardDto.getAmountUsed());
        card.setAvailableAmount(cardDto.getAvailableAmount());


        return card;
    }

    public static CardDto toCardDto(Card card, CardDto cardDto){

        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setMobileNumber(card.getMobileNumber());
        cardDto.setCardType(card.getCardType());
        cardDto.setTotalLimit(card.getTotalLimit());
        cardDto.setAvailableAmount(card.getAvailableAmount());
        cardDto.setAmountUsed(card.getAmountUsed());


        return cardDto;
    }
}
