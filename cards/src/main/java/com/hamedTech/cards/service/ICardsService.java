package com.hamedTech.cards.service;

import com.hamedTech.cards.dto.CardDto;

public interface ICardsService {

    void createCard(String mobileNumber);

    CardDto fetchCardDetails(String mobileNumber);

    boolean updateCardDetails(CardDto cardDto);

    boolean deleteCardDetails(String mobileNumber);
}
