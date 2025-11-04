package com.hamedTech.cards.service.impl;

import com.hamedTech.cards.mapper.CardsMapper;
import com.hamedTech.cards.constant.CardConstants;
import com.hamedTech.cards.dto.CardDto;
import com.hamedTech.cards.entity.Card;
import com.hamedTech.cards.exception.CardAlreadyExistsException;
import com.hamedTech.cards.exception.ResourceNotFoundException;
import com.hamedTech.cards.repository.CardRepository;
import com.hamedTech.cards.service.ICardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements ICardsService {

    private final CardRepository cardRepository;

    @Override
    public void createCard(String mobileNumber) {

        Optional<Card> card = cardRepository.findByMobileNumber(mobileNumber);

        if(card.isPresent()){
            throw new  CardAlreadyExistsException("card is already exists with the provided mobile number" + mobileNumber);
        }

        cardRepository.save(createNewCard(mobileNumber));

    }

    private Card createNewCard(String mobileNumber) {

        Card newCard = new Card();

        Long randomCardNumber = 100000000000L + new Random().nextLong(90000000000L);
        newCard.setCardNumber(randomCardNumber.toString());
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);

        return newCard;
    }


    @Override
    public CardDto fetchCardDetails(String mobileNumber) {
        Card card   = cardRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Cards", "mobileNumber", mobileNumber));

        CardDto cardDto =  CardsMapper.toCardDto(card, new CardDto());

        return cardDto;

    }

    @Override
    public boolean updateCardDetails(CardDto cardDto) {

        Card card = cardRepository.findByCardNumber(cardDto.getCardNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Card", "Card Number", cardDto.getCardNumber()));

        cardRepository.save(CardsMapper.toCard(cardDto, card));


        return true;
    }

    @Override
    public boolean deleteCardDetails(String mobileNumber) {

        Card card = cardRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "Mobile number", mobileNumber));

        cardRepository.deleteById(card.getCardId());

        return true;
    }
}
